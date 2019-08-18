package com.hand.app.service;

import com.hand.domain.entity.Item;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:34
 */
public interface ItemService {

    /**
     * 分页查询物料信息
     * @param pageRequest 分页参数
     * @param item 查询参数
     * @return 物料信息列表
     */
    Page<Item> pageItem(PageRequest pageRequest, Item item);
}
