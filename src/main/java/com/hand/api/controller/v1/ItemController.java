package com.hand.api.controller.v1;

import com.hand.app.service.ItemService;
import com.hand.config.SwaggerApiConfig;
import com.hand.domain.entity.Item;
import com.hand.domain.repository.ItemRepository;
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
@Api(tags = SwaggerApiConfig.ITEM)
@RestController("itemController.v1")
@RequestMapping("/v1/items")
public class ItemController extends BaseController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @Permission(level = ResourceLevel.ORGANIZATION)
    @ApiOperation(value = "根据条件分页查询物料")
    @GetMapping
    public ResponseEntity<Page<Item>> pageItem(Item item, PageRequest pageRequest) {
        return Results.success(itemService.pageItem(pageRequest, item));
    }
}
