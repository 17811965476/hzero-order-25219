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
@ApiModel("客户信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_customer")
public class Customer extends AuditDomain {

    @Id
    @GeneratedValue
    private Long customerId;

    @NotNull(message = "客户编号不能为空")
    @ApiModelProperty("客户编号")
    private String customerNumber;

    @NotNull(message = "客户名称不能为空")
    @ApiModelProperty("客户名称")
    private String customerName;

    @NotNull(message = "公司ID不能为空")
    @ApiModelProperty("公司ID")
    private Long companyId;

    @ApiModelProperty("启用标识")
    private Long enabledFlag;

    @NotNull(message = "创建者不能为空")
    @ApiModelProperty("创建者")
    private Long createdBy;

    @ApiModelProperty("创建日期")
    private Date creationDate;

    @NotNull(message = "更新者不能为空")
    @ApiModelProperty("更新者")
    private Long lastUpdatedBy;

    @ApiModelProperty("更新日期")
    private Date lastUpdateDate;

    @ApiModelProperty("版本号")
    private Long objectVersionNumber;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Long enabledFlag) {
        this.enabledFlag = enabledFlag;
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

    @Override
    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    @Override
    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
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
        return "Customer{" +
                "customerId=" + customerId +
                ", customerNumber='" + customerNumber + '\'' +
                ", customerName='" + customerName + '\'' +
                ", companyId=" + companyId +
                ", enabledFlag=" + enabledFlag +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", objectVersionNumber=" + objectVersionNumber +
                '}';
    }
}
