package com.hand.domain.repository;

import com.hand.api.dto.OrderDTO;
import com.hand.domain.entity.OrderLine;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.hzero.mybatis.base.BaseRepository;

import java.util.List;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:19
 */
public interface OrderLineRepository extends BaseRepository<OrderLine> {


    /**
     * 根据订单号分页查询订单行信息
     * @param pageRequest 分页参数
     * @param orderNumber 订单号
     * @return 订单行信息列表
     */
    public List<OrderDTO> pageByOrderNumber(PageRequest pageRequest, String orderNumber);

    /**
     * 删除指定订单的订单行信息
     * @param orderNumber 订单号
     */
    public void deleteByOrderNumber(String orderNumber);

    /**
     * 获取订单行所属订单状态
     * @param soLineId 订单行信息ID
     * @return 订单状态
     */
    public String getOrderStatus(Long soLineId);
}
