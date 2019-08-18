package com.hand.api.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hzero.export.annotation.ExcelColumn;
import org.hzero.export.annotation.ExcelSheet;

import java.util.Date;

/**
 * @author rongfeng.xie@hand-china.com
 * @create 2019/8/7 15:32
 */
@ExcelSheet(zh = "订单数据", en = "Order Detail")
public class OrderDTO {

    public static final String STATUS_NEW = "NEW";
    public static final String STATUS_SUBMITED = "SUBMITED";
    public static final String STATUS_APPROVED = "APPROVED";
    public static final String STATUS_REJECTED = "REJECTED";
    public static final String STATUS_CLOSE = "CLOSE";

    @ExcelColumn(zh = "销售订单号", en = "orderNumber")
    @ApiModelProperty("订单号")
    private String orderNumber;

    @ApiModelProperty("公司ID")
    private Long companyId;

    @ExcelColumn(zh = "公司名称", en = "companyName")
    @ApiModelProperty("公司名称")
    private String companyName;

    @ApiModelProperty("客户ID")
    private Long customerId;

    @ExcelColumn(zh = "客户名称", en = "customerName")
    @ApiModelProperty("客户名称")
    private String customerName;

    @ExcelColumn(zh = "物料编码", en = "itemCode")
    @ApiModelProperty("物料ID")
    private Long itemId;

    @ExcelColumn(zh = "物料数量", en = "orderQuantity")
    @ApiModelProperty("物料数量")
    private Double orderQuantity;

    @ExcelColumn(zh = "物料单价", en = "unitSellingPrice")
    @ApiModelProperty("物料单价")
    private Double unitSellingPrice;

    @ExcelColumn(zh = "物料单位", en = "orderQuantityUom")
    @ApiModelProperty("物料单位")
    private String orderQuantityUom;

    @ExcelColumn(zh = "物料描述", en = "itemDescription")
    @ApiModelProperty("物料描述")
    private String itemDescription;

    @ExcelColumn(zh = "行号", en = "lineNumber")
    @ApiModelProperty("行号")
    private Integer lineNumber;

    @ExcelColumn(zh = "行金额", en = "lineAmount")
    @ApiModelProperty("行金额")
    private Double lineAmount;

    @ExcelColumn(zh = "订单状态", en = "orderStatus")
    @ApiModelProperty("订单状态")
    private String orderStatus;

    @ExcelColumn(zh = "订单日期", en = "orderDate")
    @ApiModelProperty("订单日期")
    private Date orderDate;

    @ExcelColumn(zh = "订单金额", en = "orderAmount")
    @ApiModelProperty("订单金额")
    private Double orderAmount;

    @ExcelColumn(zh = "订单备注", en = "description")
    @ApiModelProperty("订单备注")
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

    @ApiModelProperty("创建者")
    private Long createdBy;

    @ApiModelProperty("创建时间")
    private Date creationDate;

    @ApiModelProperty("更新者")
    private Long lastUpdatedBy;

    @ApiModelProperty("更新日期")
    private Date lastUpdateDate;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Double getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(Double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public Double getUnitSellingPrice() {
        return unitSellingPrice;
    }

    public void setUnitSellingPrice(Double unitSellingPrice) {
        this.unitSellingPrice = unitSellingPrice;
    }

    public String getOrderQuantityUom() {
        return orderQuantityUom;
    }

    public void setOrderQuantityUom(String orderQuantityUom) {
        this.orderQuantityUom = orderQuantityUom;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
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

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(Long lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(Integer lineNumber) {
        this.lineNumber = lineNumber;
    }

    public Double getLineAmount() {
        return lineAmount;
    }

    public void setLineAmount(Double lineAmount) {
        this.lineAmount = lineAmount;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderNumber='" + orderNumber + '\'' +
                ", companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", itemId=" + itemId +
                ", orderQuantity=" + orderQuantity +
                ", unitSellingPrice=" + unitSellingPrice +
                ", orderQuantityUom='" + orderQuantityUom + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                ", lineNumber=" + lineNumber +
                ", lineAmount=" + lineAmount +
                ", orderStatus='" + orderStatus + '\'' +
                ", orderDate=" + orderDate +
                ", orderAmount=" + orderAmount +
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
                '}';
    }
}
