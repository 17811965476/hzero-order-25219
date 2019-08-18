package com.hand.infra.repository.impl;

import com.hand.api.dto.OrderDTO;
import com.hand.domain.entity.OrderLine;
import com.hand.domain.repository.OrderLineRepository;
import com.hand.infra.mapper.OrderHeaderMapper;
import com.hand.infra.mapper.OrderLineMapper;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:31
 */
@Component
public class OrderLineRepositoryImpl extends BaseRepositoryImpl<OrderLine> implements OrderLineRepository {

    private final OrderHeaderMapper orderHeaderMapper;
    private final OrderLineMapper orderLineMapper;

    public OrderLineRepositoryImpl(OrderHeaderMapper orderHeaderMapper, OrderLineMapper orderLineMapper) {
        this.orderHeaderMapper = orderHeaderMapper;
        this.orderLineMapper = orderLineMapper;
    }

    @Override
    public Page<OrderDTO> pageByOrderNumber(PageRequest pageRequest, String orderNumber) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderNumber(orderNumber);
        return PageHelper.doPage(pageRequest, () -> orderHeaderMapper.selectOrder(orderDTO));
    }

    @Override
    public void deleteByOrderNumber(String orderNumber) {
        orderLineMapper.deleteByOrderNumber(orderNumber);
    }

    @Override
    public String getOrderStatus(Long soLineId) {
        return orderLineMapper.getOrderStatus(soLineId);
    }
}
