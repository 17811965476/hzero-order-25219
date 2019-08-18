package com.hand.infra.repository.impl;

import com.hand.domain.entity.Company;
import com.hand.domain.repository.CompanyRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:29
 */
@Component
public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {
}
