package com.hand.infra.repository.impl;

import com.hand.api.dto.OrderDTO;
import com.hand.domain.entity.OrderHeader;
import com.hand.domain.repository.OrderHeaderRepository;
import com.hand.infra.mapper.OrderHeaderMapper;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.PageHelper;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.mybatis.util.StringUtil;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:30
 */
@Component
public class OrderHeaderRepositoryImpl extends BaseRepositoryImpl<OrderHeader> implements OrderHeaderRepository {

    private final OrderHeaderMapper orderHeaderMapper;

    public OrderHeaderRepositoryImpl(OrderHeaderMapper orderHeaderMapper) {
        this.orderHeaderMapper = orderHeaderMapper;
    }

    @Override
    public Page<OrderDTO> pageOrder(PageRequest pageRequest, OrderDTO orderDTO) {
        return PageHelper.doPage(pageRequest, () -> orderHeaderMapper.selectOrder(orderDTO));
    }

    @Override
        public OrderDTO getByOrderNumber(String orderNumber) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderNumber(orderNumber);
        List<OrderDTO> list = orderHeaderMapper.selectOrder(orderDTO);
        if(!list.isEmpty()) {
            orderDTO =  list.get(0);
        }
        return orderDTO;
    }

    @Override
    public String getOrderStatus(Long soHeaderId) {
        OrderHeader orderHeader = orderHeaderMapper.selectByPrimaryKey(soHeaderId);
        if(orderHeader != null) {
            return orderHeader.getOrderStatus();
        }
        return "";
    }

    @Override
    public void autoUpdateOrderStatus() {
        orderHeaderMapper.autoUpdateOrderStatus();
    }

}
