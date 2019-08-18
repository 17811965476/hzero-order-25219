package com.hand.app.service;

import org.hzero.boot.scheduler.infra.annotation.JobHandler;
import org.hzero.boot.scheduler.infra.enums.ReturnT;
import org.hzero.boot.scheduler.infra.handler.IJobHandler;
import org.hzero.boot.scheduler.infra.tool.SchedulerTool;

import java.util.Map;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/9 15:49
 */
@JobHandler("autoUpdateOrderStatus-25219")
public class JobService implements IJobHandler {

    private final OrderService orderService;

    public JobService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ReturnT execute(Map<String, String> map, SchedulerTool tool) {
        orderService.autoUpdateOrderStatus();
        return ReturnT.SUCCESS;
    }
}
