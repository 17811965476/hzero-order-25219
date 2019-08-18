package com.hand.config;

import io.choerodon.core.swagger.ChoerodonRouteData;
import io.choerodon.swagger.annotation.ChoerodonExtraData;
import io.choerodon.swagger.swagger.extra.ExtraData;
import io.choerodon.swagger.swagger.extra.ExtraDataManager;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 19:51
 */
@ChoerodonExtraData
public class OrderExtraDataManager implements ExtraDataManager {

    @Override
    public ExtraData getData() {
        ChoerodonRouteData choerodonRouteData = new ChoerodonRouteData();
        choerodonRouteData.setName("hodr");
        choerodonRouteData.setPath("/order/**");
        choerodonRouteData.setServiceId("hzero-order-25219");
        extraData.put(ExtraData.ZUUL_ROUTE_DATA, choerodonRouteData);
        return extraData;
    }
}
