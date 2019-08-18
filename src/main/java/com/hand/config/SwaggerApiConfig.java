package com.hand.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.Tag;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 19:39
 */
@Configuration
public class SwaggerApiConfig {

    public static final String COMPANY = "Company";
    public static final String CUSTOMER = "Customer";
    public static final String ITEM = "Item";
    public static final String ORDER = "Order";

    @Autowired
    public SwaggerApiConfig(Docket docket) {
        docket.tags(
                new Tag(COMPANY, "公司信息"),
                new Tag(CUSTOMER, "客户信息"),
                new Tag(ITEM, "物料信息"),
                new Tag(ORDER, "订单信息")
                );
    }
}
