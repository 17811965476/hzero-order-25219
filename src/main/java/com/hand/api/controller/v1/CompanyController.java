package com.hand.api.controller.v1;

import com.hand.app.service.CompanyService;
import com.hand.config.SwaggerApiConfig;
import com.hand.domain.entity.Company;
import com.hand.domain.repository.CompanyRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.hzero.mybatis.domian.Condition;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 20:40
 */
@Api(tags = SwaggerApiConfig.COMPANY)
@RestController("companyController.v1")
@RequestMapping("/v1/companies")
public class CompanyController extends BaseController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "根据条件分页查询公司")
    @GetMapping
    public ResponseEntity<Page<Company>> pageCompany(Company company, PageRequest pageRequest) {
        return Results.success(companyService.pageCompany(pageRequest, company));
    }

}
