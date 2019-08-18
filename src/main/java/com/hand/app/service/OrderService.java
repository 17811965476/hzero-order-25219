package com.hand.app.service;

import com.hand.api.dto.OrderDTO;
import com.hand.domain.entity.OrderHeader;
import com.hand.domain.entity.OrderLine;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

import java.io.InputStream;
import java.util.Map;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:34
 */
public interface OrderService {

    /**
     * 分页查询订单
     * @param orderDTO 查询参数
     * @param pageRequest 分页参数
     * @return 订单信息列表
     */
    Page<OrderDTO> pageOrder(PageRequest pageRequest, OrderDTO orderDTO);

    /**
     * 获取订单详细信息
     * @param pageRequest 分页参数
     * @param orderNumber 订单编号
     * @return 订单详细信息
     */
    Map<String, Object> getOrderDetail(PageRequest pageRequest, String orderNumber);

    /**
     * 更新订单头信息
     * @param orderHeader 更新参数
     * @return 更新后的订单头信息
     */
    OrderHeader updateOrderHeader(OrderHeader orderHeader);

    /**
     * 更新订单行信息
     * @param orderLine 更新参数
     * @return 更新后的订单行信息
     */
    OrderLine updateOrderLine(OrderLine orderLine);

    /**
     * 新增订单头信息
     * @param orderHeader 新增信息
     * @return 新增的头信息
     */
    OrderHeader createOrderHeader(OrderHeader orderHeader);

    /**
     * 新增订单行信息
     * @param orderLine 新增信息
     * @return 新增的行信息
     */
    OrderLine createOrderLine(OrderLine orderLine);

    /**
     * 删除指定订单行信息
     * @param soLineId 要删除的订单行信息ID
     */
    void deleteOrderLine(Long soLineId);

    /**
     * 删除指定的订单
     * @param orderNumber 订单号
     */
    void deleteOrder(String orderNumber);

    /**
     * 获取订单状态
     * @param soHeaderId 头信息ID
     * @param soLineId 行信息ID
     * @return 订单状态
     */
    String getOrderStatus(Long soHeaderId, Long soLineId);

    /**
     * 修改订单状态
     * @param orderHeader 更新参数
     */
    void updateOrderStatus(OrderHeader orderHeader);

    /**
     * 自动关闭审批通过的订单
     */
    void autoUpdateOrderStatus();

    /**
     * 将订单数据导出为PDF文件
     * @param orderDetail 订单详细数据
     */
    void exportOrder2Pdf(Map<String, Object> orderDetail);
}
