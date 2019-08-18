package com.hand.infra.repository.impl;

import com.hand.domain.entity.Item;
import com.hand.domain.repository.ItemRepository;
import org.hzero.mybatis.base.impl.BaseRepositoryImpl;
import org.springframework.stereotype.Component;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 0:30
 */
@Component
public class ItemRepositoryImpl extends BaseRepositoryImpl<Item> implements ItemRepository {
}
