####MVC模式
    Model模型
    一个个功能。用javaBean实现
    处理业务逻辑（封装业务逻辑的JavaBean）
    处理数据（封装数据的JavaBean）
    
    View视图
    用户可见的，用于展示以及与用户交互。使用各种前端技术
    界面展示、人机交互
    
    Controller控制器/分发器
    接收请求，将请求跳转到模型进行处理；模型处理完在将结果返回给控制器，由控制器给View。一般使用Servlet。
    视图、模型的选择（分发）
####web.xml加载过程
    ①Servlet容器先读取两个节点<listener>和<contex-param>
    ②容器创建一个ServletContext，应用范围内即整个WEB项目
    ③容器读取到<context-param>转化为键值对,存入ServletContext。
    ④容器创建<listener>中的类实例,即创建监听
    ⑤在监听器的contextInitialized方法中从ServletContext获得<context-param>的值，做一些相应的操作
    ⑥容器读取<filter>创建实例。
    以上都是在WEB项目还没有完全启动起来的时候就已经完成了的工作。
    
    总的来说：<context-param>-><listener>-><filter>-><servlet>
    如果web.xml中出现了相同的元素，则按照在配置文件中出现的先后顺序来加载。
    
    Spring web中，WebApplicationContext在监听器ContextLoaderListener的contextInitialized方法中被创建，
    在contextDestroyed方法中被销毁
####ServletContext
    ServletContext就是一个“域对象”，它存在于整个应用中，并在在整个应用中有且仅有1份，它表示了当前整个应用的
    “状态”，可以理解为某个时刻的ServletContext代表了这个应用在某个时刻的“一张快照”，这张“快照”里面包
    含了有关应用的许多信息，应用的所有组件都可以从ServletContext获取当前应用的状态信息。ServletContext随着程序
    的启动而创建，随着程序的停止而销毁。

    