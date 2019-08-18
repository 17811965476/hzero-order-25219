package com.hand.api.controller.v1;

import com.hand.api.dto.OrderDTO;
import com.hand.app.service.OrderService;
import com.hand.config.SwaggerApiConfig;
import com.hand.domain.entity.OrderHeader;
import com.hand.domain.entity.OrderLine;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.util.StringUtil;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.export.annotation.ExcelExport;
import org.hzero.export.vo.ExportParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 16:23
 */
@Api(tags = SwaggerApiConfig.ORDER)
@RestController("orderController.v1")
@RequestMapping("/v1/orders")
public class OrderController extends BaseController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "根据查询条件分页查询订单")
    @GetMapping
    public ResponseEntity<Page<OrderDTO>> pageOrder(OrderDTO orderDTO, PageRequest pageRequest) {
        this.validObject(orderDTO);
        return Results.success(orderService.pageOrder(pageRequest, orderDTO));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "根据查询条件导出订单")
    @GetMapping("/export")
    @ExcelExport(OrderDTO.class)
    public ResponseEntity export(OrderDTO orderDTO, ExportParam exportParam, HttpServletResponse response, PageRequest pageRequest) {
        List<OrderDTO> list = orderService.pageOrder(pageRequest, orderDTO);
        return Results.success(list);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "根据订单号查询订单详细信息")
    @GetMapping("/detail")
    public ResponseEntity<Map<String, Object>> orderDetail(PageRequest pageRequest, String orderNumber) {
        if(StringUtil.isEmpty(orderNumber)) {
            return Results.error();
        }
        Map<String, Object> map = orderService.getOrderDetail(pageRequest, orderNumber);
        return Results.success(map);
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "新建订单头信息")
    @GetMapping("/new/orderHeader")
    public ResponseEntity<OrderHeader> newOrderHeader(@RequestBody OrderHeader orderHeader) {
        this.validObject(orderHeader);
        return Results.success(orderService.createOrderHeader(orderHeader));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "编辑订单头信息")
    @GetMapping("/edit/orderHeader")
    public ResponseEntity<OrderHeader> editOrderHeader(@RequestBody OrderHeader orderHeader) {
        // 获取订单当前状态
        String orderStatus = orderService.getOrderStatus(orderHeader.getSoHeaderId(), null);
        //  ”新建“或”已拒绝“允许编辑
        if(OrderDTO.STATUS_NEW.equals(orderStatus) || OrderDTO.STATUS_REJECTED.equals(orderStatus)) {
            // 不可审批或拒绝
            if(OrderDTO.STATUS_APPROVED.equals(orderHeader.getOrderStatus()) || OrderDTO.STATUS_REJECTED.equals(orderHeader.getOrderStatus())) {
                return Results.error();
            }
            this.validObject(orderHeader);
            return Results.success(orderService.updateOrderHeader(orderHeader));
        } else if(OrderDTO.STATUS_SUBMITED.equals(orderStatus)) {
                // "已提交"可审批或拒绝
                if(OrderDTO.STATUS_APPROVED.equals(orderHeader.getOrderStatus()) || OrderDTO.STATUS_REJECTED.equals(orderHeader.getOrderStatus())) {
                    orderService.updateOrderStatus(orderHeader);
                }
            }
        return Results.error();
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "新建订单行信息")
    @GetMapping("/new/orderLine")
    public ResponseEntity<OrderLine> newOrderLine(@RequestBody OrderLine orderLine) {
        this.validObject(orderLine);
        return Results.success(orderService.createOrderLine(orderLine));
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "编辑订单行信息")
    @GetMapping("/edit/orderLine")
    public ResponseEntity<OrderLine> editOrderLine(@RequestBody OrderLine orderLine) {
        String orderStatus = orderService.getOrderStatus(null, orderLine.getSoLineId());
        if(OrderDTO.STATUS_SUBMITED.equals(orderStatus) || OrderDTO.STATUS_APPROVED.equals(orderStatus)) {
            this.validObject(orderLine);
            return Results.success(orderService.updateOrderLine(orderLine));
        }
        return Results.error();
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "删除订单")
    @GetMapping("/delete")
    public ResponseEntity deleteOrder(@RequestBody OrderHeader orderHeader) {
        String orderStatus = orderService.getOrderStatus(orderHeader.getSoHeaderId(), null);
        if(OrderDTO.STATUS_SUBMITED.equals(orderStatus) || OrderDTO.STATUS_APPROVED.equals(orderStatus)) {
            this.validObject(orderHeader);
            orderService.deleteOrder(orderHeader.getOrderNumber());
            return Results.success();
        }
        return Results.error();
    }

//    @Permission(level = ResourceLevel.ORGANIZATION)
//    @ApiOperation(value = "根据查询条件导出订单PDF")
//    @GetMapping("/export2pdf")
//    public ResponseEntity export2Pdf(OrderDTO orderDTO, PageRequest pageRequest) {
////        List<OrderDTO> list = orderService.pageOrder(pageRequest, orderDTO);
//        orderService.exportOrder2Pdf(new HashMap<>());
//        return Results.success();
//    }
}
