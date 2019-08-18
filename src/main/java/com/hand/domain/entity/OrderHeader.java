package com.hand.domain.entity;

import io.choerodon.mybatis.annotation.ModifyAudit;
import io.choerodon.mybatis.annotation.VersionAudit;
import io.choerodon.mybatis.domain.AuditDomain;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/6 20:12
 */
@ApiModel("订单头信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_so_header")
public class OrderHeader extends AuditDomain {

    @Id
    @GeneratedValue
    private Long soHeaderId;

    @NotNull(message = "订单编号不能为空")
    @ApiModelProperty("订单编号")
    private String orderNumber;

    @NotNull(message = "公司ID不能为空")
    @ApiModelProperty("公司ID")
    private Long companyId;

    @NotNull(message = "订单日期不能为空")
    @ApiModelProperty("订单日期")
    private java.sql.Date orderDate;

    @ApiModelProperty("订单状态")
    private String orderStatus;

    @NotNull(message = "客户ID不能为空")
    @ApiModelProperty("客户ID")
    private Long customerId;

    @NotNull(message = "创建者不能为空")
    @ApiModelProperty("创建者")
    private Long createdBy;

    @NotNull(message = "物料编号不能为空")
    @ApiModelProperty("创建日期")
    private Date creationDate;

    @NotNull(message = "更新者不能为空")
    @ApiModelProperty("更新者")
    private Long laseUpdatedBy;

    @ApiModelProperty("更新日期")
    private Date lastUpdateDate;

    @ApiModelProperty("版本号")
    private Long objectVersionNumber;

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public java.sql.Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(java.sql.Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Override
    public Long getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLaseUpdatedBy() {
        return laseUpdatedBy;
    }

    public void setLaseUpdatedBy(Long laseUpdatedBy) {
        this.laseUpdatedBy = laseUpdatedBy;
    }

    @Override
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    @Override
    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public Long getObjectVersionNumber() {
        return objectVersionNumber;
    }

    @Override
    public void setObjectVersionNumber(Long objectVersionNumber) {
        this.objectVersionNumber = objectVersionNumber;
    }

    @Override
    public String toString() {
        return "OrderHeader{" +
                "soHeaderId=" + soHeaderId +
                ", orderNumber='" + orderNumber + '\'' +
                ", companyId=" + companyId +
                ", orderDate=" + orderDate +
                ", orderStatus='" + orderStatus + '\'' +
                ", customerId=" + customerId +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", laseUpdatedBy=" + laseUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", objectVersionNumber=" + objectVersionNumber +
                '}';
    }
}
