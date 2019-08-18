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
@ApiModel("订单行信息")
@ModifyAudit
@VersionAudit
@Table(name = "hodr_so_line")
public class OrderLine extends AuditDomain {

    @Id
    @GeneratedValue
    private Long soLineId;

    @NotNull(message = "订单头ID不能为空")
    @ApiModelProperty("订单头ID")
    private Long soHeaderId;

    @NotNull(message = "订单行号不能为空")
    @ApiModelProperty("订单行号")
    private Long lineNumber;

    @NotNull(message = "物料ID不能为空")
    @ApiModelProperty("物料ID")
    private Long itemId;

    @NotNull(message = "产品数量不能为空")
    @ApiModelProperty("产品数量")
    private double orderQuantity;

    @NotNull(message = "产品单位不能为空")
    @ApiModelProperty("产品单位")
    private String orderQuantityUom;

    @NotNull(message = "销售单价不能为空")
    @ApiModelProperty("销售单价")
    private double unitSellingPrice;

    @ApiModelProperty("备注")
    private String description;

    @ApiModelProperty("附加信息1")
    private String addition1;

    @ApiModelProperty("附加信息2")
    private String addition2;

    @ApiModelProperty("附加信息3")
    private String addition3;

    @ApiModelProperty("附加信息4")
    private String addition4;

    @ApiModelProperty("附加信息5")
    private String addition5;

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

    public Long getSoLineId() {
        return soLineId;
    }

    public void setSoLineId(Long soLineId) {
        this.soLineId = soLineId;
    }

    public Long getSoHeaderId() {
        return soHeaderId;
    }

    public void setSoHeaderId(Long soHeaderId) {
        this.soHeaderId = soHeaderId;
    }

    public Long getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Long lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public double getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(double unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddition1() {
        return addition1;
    }

    public void setAddition1(String addition1) {
        this.addition1 = addition1;
    }

    public String getAddition2() {
        return addition2;
    }

    public void setAddition2(String addition2) {
        this.addition2 = addition2;
    }

    public String getAddition3() {
        return addition3;
    }

    public void setAddition3(String addition3) {
        this.addition3 = addition3;
    }

    public String getAddition4() {
        return addition4;
    }

    public void setAddition4(String addition4) {
        this.addition4 = addition4;
    }

    public String getAddition5() {
        return addition5;
    }

    public void setAddition5(String addition5) {
        this.addition5 = addition5;
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
        return "OrderLine{" +
                "soLineId=" + soLineId +
                ", soHeaderId=" + soHeaderId +
                ", lineNumber=" + lineNumber +
                ", itemId=" + itemId +
                ", orderQuantity=" + orderQuantity +
                ", orderQuantityUom='" + orderQuantityUom + '\'' +
                ", unitSellingPrice=" + unitSellingPrice +
                ", description='" + description + '\'' +
                ", addition1='" + addition1 + '\'' +
                ", addition2='" + addition2 + '\'' +
                ", addition3='" + addition3 + '\'' +
                ", addition4='" + addition4 + '\'' +
                ", addition5='" + addition5 + '\'' +
                ", createdBy=" + createdBy +
                ", creationDate=" + creationDate +
                ", lastUpdatedBy=" + lastUpdatedBy +
                ", lastUpdateDate=" + lastUpdateDate +
                ", objectVersionNumber=" + objectVersionNumber +
                '}';
    }
}
