package com.hand.domain.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
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
 * @create 2019/8/6 20:11
 */
@ApiModel("公司信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_company")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Company extends AuditDomain {

    @Id
    @GeneratedValue
    private Long companyId;

    @NotNull(message = "公司编号不能为空")
    @ApiModelProperty("公司编号")
    private String companyNumber;

    @NotNull(message = "公司名称不能为空")
    @ApiModelProperty("公司名称")
    private String companyName;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
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
        return "Company{" +
                "companyId=" + companyId +
                ", companyNumber='" + companyNumber + '\'' +
                ", companyName='" + companyName + '\'' +
                ", enabledFlag=" + enabledFlag +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", objectVersionNumber=" + objectVersionNumber +
                '}';
    }
}
