# hzero_order_25219
#### 简介： 上海汉得信息技术股份有限公司 Hzero考核 (销售订单)
#### 部门： 管理会计事业部
#### 姓名： 谢荣峰
#### 工号： 25219
***
### 概述
#### 开发目的
通过该考核来测试培训人员对Hzero的掌握情况。
#### 开发内容
开发一个销售订单管理平台，来查询、录入、编辑、导出销售订单信息及销售订单报表等。
#### 开发框架
Hzero (0.10.0)
#### 开发环境
* MySQL
* Redis
* JDK1.8
### 开发列表
1. 销售订单汇总查询页面
2. 录入、编辑、查看销售订单页面(含编码规则使用、附件处理)
3. 导出销售订单信息至Excel
4. 销售订单定时关闭
5. 销售订单单据报表打印（选做）
6. 销售订单Excel导入（选做）
7. 工作流订单审批（选做）
8. 按钮权限控制
### 数据库设计 
* 公司主数据：hodr_company
    * 表设计
    ![hodr_company](/img/hodr_company.png)
    * 索引
    ![hodr_company—_index](/img/hodr_company_index.png)
* 客户主数据：hodr_customer
    * 表设计
    ![hodr_customer](/img/hodr_customer.png)
    * 索引
    ![hodr_customer_index](/img/hodr_customer_index.png)
* 物料主数据：hodr_item
    * 表设计
    ![hodr_item](/img/hodr_item.png)
    * 索引
    ![hodr_item_index](/img/hodr_item_index.png)
* 业务数据表 - 销售订单头信息：hodr_so_header
    * 表设计
    ![hodr_so_header](/img/hodr_so_header.png)
    * 索引
    ![hodr_so_header_index](/img/hodr_so_header_index.png)
* 业务数据表 - 销售订单行信息：hodr_so_line
    * 表设计
    ![hodr_so_line](/img/hodr_so_line.png)
    * 索引
    ![hodr_so_line_index](/img/hodr_so_line_index.png)
### 实现功能
* 基于查询公司、客户、销售订单号、物料、订单状态查询销售订单数据
* 查询订单数据
* 导出订单数据（基于 Excel）
* 实现新增/更改/查看销售订单，禁止销售订单被删除
* 销售订单自动关闭功能
### 启动说明
1. 新建数据库hzero_order
2. 运行![hzero_order.sql](hzero_order.sql)文件，新建数据表，导入数据
3. 依照![Hzero本地部署说明](hzero_starter/hzero_starter.pdf)搭建Hzero开发环境，数据库脚本见![Hzero本地部署数据库](/hzero_starter/hzero_resource.zip)
4. Hzero本地部署完成，依次启动Hzero服务。打开![eureka](http://dev.hzero.org:8000/)查看服务启动情况
5. 修改本项目![application.yml](/src/main/resources/application.yml)文件中MySQL数据库地址、用户名、密码
6. 修改本项目![application.yml](/src/main/resources/application.yml)文件中注册中心地址
7. 修改本项目![bootstrap.yml](/src/main/resources/bootstrap.yml)文件中配置中心地址
8. 启动服务，打开![Swagger](http://dev.hzero.org:8080/swagger/swagger-ui.html)查看接口详情
### 接口说明
* /v1/companies  
根据条件分页获取公司列表
* /v1/customers  
根据条件分页获取客户列表
* /v1/items  
根据条件分页查询物料
* /v1/orders  
   * 根据查询条件分页查询订单
   * /export  
   根据查询条件导出订单
   * /detail  
   根据订单号查询订单详细信息
   * /new/orderHeader  
   新建订单头信息  
   * /new/orderLine  
   新建订单行信息  
   * /edit/orderHeader  
   编辑订单头信息  
   * /edit/orderLine  
   编辑订单行信息  
   * /delete  
   删除订单
* 订单自动关闭任务
任务名称： autoUpdateOrderStatus-25219


