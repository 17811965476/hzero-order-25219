package com.hand.infra.mapper;

import com.hand.api.dto.OrderDTO;
import com.hand.domain.entity.OrderHeader;
import io.choerodon.mybatis.common.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:23
 */
@Component
public interface OrderHeaderMapper extends BaseMapper<OrderHeader> {

    /**
     * 根据条件查询订单
     * @param orderDTO 查询参数
     * @return 查询结果
     */
    List<OrderDTO> selectOrder(OrderDTO orderDTO);

//    /**
//     * 根据订单号获取订单头信息
//     * @param orderNumber 订单编号
//     * @return 订单头信息
//     */
//    OrderHeader getByOrderNumber(String orderNumber);

    /**
     * 自动关闭审批通过的订单
     */
    void autoUpdateOrderStatus();
}
