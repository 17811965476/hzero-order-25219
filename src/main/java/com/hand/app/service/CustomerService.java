package com.hand.app.service;


import com.hand.domain.entity.Customer;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:34
 */
public interface CustomerService {

    /**
     * 分页查询客户信息
     * @param pageRequest 分页参数
     * @param customer 查询参数
     * @return 客户信息列表
     */
    Page<Customer> pageCustomer(PageRequest pageRequest, Customer customer);
}
