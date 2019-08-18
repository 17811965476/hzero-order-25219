package com.hand.app.service.impl;

import com.hand.api.dto.OrderDTO;
import com.hand.app.service.OrderService;
import com.hand.domain.entity.OrderHeader;
import com.hand.domain.entity.OrderLine;
import com.hand.domain.repository.OrderHeaderRepository;
import com.hand.domain.repository.OrderLineRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import io.choerodon.core.domain.Page;
import io.choerodon.core.exception.CommonException;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:36
 */
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderHeaderRepository orderHeaderRepository;
    private final OrderLineRepository orderLineRepository;
    // 导出pdf临时文件地址
    private static final String ORDER_EXPORT = "target/order_export.pdf";

    public OrderServiceImpl(OrderHeaderRepository orderHeaderRepository, OrderLineRepository orderLineRepository) {
        this.orderHeaderRepository = orderHeaderRepository;
        this.orderLineRepository = orderLineRepository;
    }

    @Override
    public Page<OrderDTO> pageOrder(PageRequest pageRequest, OrderDTO orderDTO) {
        return orderHeaderRepository.pageOrder(pageRequest, orderDTO);
    }

    @Override
    public Map<String, Object> getOrderDetail(PageRequest pageRequest, String orderNumber) {
        Map<String, Object> orderDetail = new HashMap<>();
        orderDetail.put("orderHeader", orderHeaderRepository.getByOrderNumber(orderNumber));
        orderDetail.put("orderLineList", orderLineRepository.pageByOrderNumber(pageRequest, orderNumber));
        return orderDetail;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderHeader updateOrderHeader(OrderHeader orderHeader) {
        OrderHeader exist = orderHeaderRepository.selectByPrimaryKey(orderHeader);
        if(exist == null) {
            throw new CommonException("hodr.warn.order.notFound");
        }
        orderHeaderRepository.updateOptional(orderHeader,
                "orderNumber",
                "companyId",
                "customerId",
                "orderDate");
        return orderHeader;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderLine updateOrderLine(OrderLine orderLine) {
        OrderLine exist = orderLineRepository.selectByPrimaryKey(orderLine);
        if(exist == null) {
            throw new CommonException("hodr.warn.order.notFound");
        }
        orderLineRepository.updateOptional(orderLine,
                "itemId",
                "orderQuantity",
                "orderQuantityUom",
                "unitSellingPrice",
                "description",
                "addition1",
                "addition2",
                "addition3",
                "addition4",
                "addition5");
        return orderLine;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderHeader createOrderHeader(OrderHeader orderHeader) {
        orderHeaderRepository.insert(orderHeader);
        return orderHeader;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public OrderLine createOrderLine(OrderLine orderLine) {
        orderLineRepository.insert(orderLine);
        return orderLine;
    }

    @Override
    public void deleteOrderLine(Long soLineId) {
        orderLineRepository.deleteByPrimaryKey(soLineId);
    }

    @Override
    public void deleteOrder(String orderNumber) {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setOrderNumber(orderNumber);
        orderLineRepository.deleteByOrderNumber(orderNumber);
        orderHeaderRepository.delete(orderHeader);
    }

    @Override
    public String getOrderStatus(Long soHeaderId, Long soLineId) {
        if (soHeaderId != null) {
            return orderHeaderRepository.getOrderStatus(soHeaderId);
        }
        return orderLineRepository.getOrderStatus(soLineId);
    }

    @Override
    public void updateOrderStatus(OrderHeader orderHeader) {
        orderHeaderRepository.updateOptional(orderHeader, "orderStatus");
    }

    @Override
    public void autoUpdateOrderStatus() {
        orderHeaderRepository.autoUpdateOrderStatus();
    }

    @Override
    public void exportOrder2Pdf(Map<String, Object> orderDetail) {
        try {
            BaseFont baseFont = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            Font font = new Font(baseFont, 24);
            Document document = new Document();
            document.setPageSize(PageSize.A4);
            PdfWriter pdfWriter = PdfWriter.getInstance(document, new FileOutputStream(ORDER_EXPORT));
            document.open();
            document.add(new Paragraph("PDF打印", new Font(baseFont, 24, Font.BOLD, new BaseColor(BaseColor.RED.getRGB()))));
            document.add(new Paragraph("主要", new Font(baseFont, 24, Font.BOLD, new BaseColor(BaseColor.BLUE.getRGB()))));
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
