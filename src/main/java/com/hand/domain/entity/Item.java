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
@ApiModel("物料信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_item")
public class Item extends AuditDomain {

    @Id
    @GeneratedValue
    private Long itemId;

    @NotNull(message = "物料编号不能为空")
    @ApiModelProperty("物料编号")
    private String itemCode;

    @NotNull(message = "物料单位不能为空")
    @ApiModelProperty("物料单位")
    private String itemUom;

    @NotNull(message = "物料描述不能为空")
    @ApiModelProperty("物料描述")
    private String itemDescription;

    @ApiModelProperty("可销售标识")
    private Long saleableFlag;

    @ApiModelProperty("生效起始时间")
    private java.sql.Date startActiveDate;

    @ApiModelProperty("生效结束时间")
    private java.sql.Date endActiveDate;

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

    @Override
    public String toString() {
        return "Item{" +
                "itemId=" + itemId +
                ", itemCode='" + itemCode + '\'' +
                ", itemUom='" + itemUom + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", saleableFlag=" + saleableFlag +
                ", startActiveDate=" + startActiveDate +
                ", endActiveDate=" + endActiveDate +
                ", enabledFlag=" + enabledFlag +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", objectVersionNumber=" + objectVersionNumber +
                '}';
    }
}
