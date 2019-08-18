package com.hand.app.service.impl;

import com.hand.app.service.CompanyService;
import com.hand.domain.entity.Company;
import com.hand.domain.repository.CompanyRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:36
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Page<Company> pageCompany(PageRequest pageRequest, Company company) {
        return companyRepository.pageAndSort(pageRequest, company);
    }
}
