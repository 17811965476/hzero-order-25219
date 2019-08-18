package com.hand.infra.repository.impl;

import com.hand.domain.entity.Customer;
import com.hand.domain.repository.CustomerRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:30
 */
@Component
public class CustomerRepositoryImpl extends BaseRepositoryImpl<Customer> implements CustomerRepository {
}
