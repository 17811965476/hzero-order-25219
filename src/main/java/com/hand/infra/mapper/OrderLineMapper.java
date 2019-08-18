package com.hand.infra.mapper;

import com.hand.domain.entity.OrderLine;
import io.choerodon.mybatis.common.BaseMapper;
import org.springframework.stereotype.Component;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:23
 */
@Component
public interface OrderLineMapper extends BaseMapper<OrderLine> {

//    /**
//     * 根据订单号分页获取订单行信息
//     * @param orderNumber 订单号
//     * @return 订单行信息列表
//     */
//    List<OrderLine> pageByOrderNumber(String orderNumber);

    /**
     * 删除指定订单的行信息
     * @param orderNumber 订单号
     */
    void deleteByOrderNumber(String orderNumber);

    /**
     * 获取订单行所属订单状态
     * @param soLineId 订单行信息ID
     * @return 订单状态
     */
    String getOrderStatus(Long soLineId);
}
