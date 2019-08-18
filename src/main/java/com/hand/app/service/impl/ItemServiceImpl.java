package com.hand.app.service.impl;

import com.hand.app.service.ItemService;
import com.hand.domain.entity.Item;
import com.hand.domain.repository.ItemRepository;
import io.choerodon.core.domain.Page;
import io.choerodon.mybatis.pagehelper.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:37
 */
@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Page<Item> pageItem(PageRequest pageRequest, Item item) {
        return itemRepository.pageAndSort(pageRequest, item);
    }
}
