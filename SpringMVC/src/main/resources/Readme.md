####三层架构
    表现层(UI)、业务逻辑层(Service)、数据访问层(Dao)
    
    实体层(Entity)   贯穿于三层，在三层之间传输数据
    
    三层架构的目的：解耦
    
    三层架构是整个应用的框架
    MVC模式是应用于三层架构的表现层的模式
####MVC模式
    Model 模型
    一个个功能。用javaBean实现，包括两类Bean：
    处理业务逻辑（封装业务逻辑的JavaBean）
    处理数据（封装数据的JavaBean）
    
    View 视图(指视图页面)
    用户可见的，用于展示以及与用户交互。使用各种前端技术，模板引擎、JSP等
    界面展示、人机交互
    
    Controller 控制器/分发器
    Controller接收请求，然后调度Model进行处理，Model处理完后将结果返回给Controller，Controller再将结果交给View渲染。一般使用Servlet。
    视图、模型的选择（分发）
    Controller的作用就是将Model和View进行关联
    
####Spring MVC
    Spring MVC是一种基于Servlet的技术
    Spring MVC将传统的模型层拆分为业务层(Service)和数据访问层(DAO)
    在Spring MVC中可以使用各种视图
   ![](Spring MVC架构.png)
####Spring MVC组件与流程
    