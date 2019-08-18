package com.hand.app.service.impl;

import com.hand.app.service.CustomerService;
import com.hand.domain.entity.Customer;
import com.hand.domain.repository.CustomerRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:36
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    @Override
    public Page<Customer> pageCustomer(PageRequest pageRequest, Customer customer) {
        return customerRepository.pageAndSort(pageRequest, customer);
    }
}
