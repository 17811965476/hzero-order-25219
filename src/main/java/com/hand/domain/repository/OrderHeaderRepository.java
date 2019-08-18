package com.hand.domain.repository;

import com.hand.api.dto.OrderDTO;
import com.hand.domain.entity.OrderHeader;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:18
 */
public interface OrderHeaderRepository extends BaseRepository<OrderHeader> {

    /**
     * 分页查询订单
     * @param pageRequest 分页参数
     * @param orderDTO 查询参数
     * @return 订单信息列表
     */
    Page<OrderDTO> pageOrder(PageRequest pageRequest, OrderDTO orderDTO);

    /**
     * 根据订单号获取订单头信息
     * @param orderNumber 订单号
     * @return 订单头信息
     */
    OrderDTO getByOrderNumber(String orderNumber);

    /**
     * 获取订单状态
     * @param soHeaderId 订单头ID
     * @return 订单状态
     */
    String getOrderStatus(Long soHeaderId);

    /**
     * 自动关闭审批通过的订单
     */
    void autoUpdateOrderStatus();
}
