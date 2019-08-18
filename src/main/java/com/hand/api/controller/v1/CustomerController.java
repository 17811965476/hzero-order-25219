package com.hand.api.controller.v1;

import com.hand.app.service.CustomerService;
import com.hand.config.SwaggerApiConfig;
import com.hand.domain.entity.Customer;
import com.hand.domain.repository.CustomerRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.core.iam.ResourceLevel;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import io.choerodon.swagger.annotation.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.hzero.core.base.BaseController;
import org.hzero.core.util.Results;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 20:40
 */
@Api(tags = SwaggerApiConfig.CUSTOMER)
@RestController("customerController.v1")
@RequestMapping("/v1/customers")
public class CustomerController extends BaseController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "根据条件分页查询客户")
    @GetMapping
    public ResponseEntity<Page<Customer>> pageCustomer(Customer customer, PageRequest pageRequest) {
        return Results.success(customerService.pageCustomer(pageRequest, customer));
    }
}
