package com.hand.app.service;

import com.hand.domain.entity.Company;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:33
 */
public interface CompanyService {

    /**
     * 分页查询公司信息
     * @param pageRequest 分页参数
     * @param company 查询参数
     * @return 公司信息列表
     */
    Page<Company> pageCompany(PageRequest pageRequest, Company company);
}
