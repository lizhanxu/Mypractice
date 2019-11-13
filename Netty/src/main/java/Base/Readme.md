#### I/O模型

##### 阻塞与非阻塞

    阻塞I/O是最常用的IO模型
    阻塞：数据没有准备好时，线程会阻塞。  缺省模式
    非阻塞：数据没有准备好时，线程不会阻塞，通常会采用轮询的方式去检查数据是否准备好

##### 同步与异步

    同步和异步都是基于应用程序和操作系统处理IO事件所采用的方式
    同步：应用程序直接参与IO读写的操作。
    异步：所有的IO读写交给搡作系统去处理，应用程序只需要等待通知。

##### I/O复用模型

    一个线程(Selector)掌握IO资源， 多个Channel注册到一个Selector上(所有IO操作阻塞在Selector上，由Selector去分配IO资源)，由Selector去检测Channel状态，从而分配IO资源，实现IO复用。
    epoll使用基于事件驱动的方式代替顺序扫描

##### 信号驱动I/O模型

    当Channel就绪时(数据准备好时)发出信号，通知此时可以进行IO操作。
    信号驱动是通知何时可以进行IO操作，异步IO是通知何时操作已完成

#### I/O多路复用技术

    把多个I/O的阻塞复用到同一个select的阻塞上，从而使得系统在单线程的情况下可以同时处理多个客户端请求

#### 网络编程

    网络编程的基本模型是C/S模型，也就是进程间通信
    
    Java中网络通信：
    服务器端通过ServerSocket建立监听，客户端通过Socket连接到指定服务器后，双方通过IO流通信

##### BIO(同步阻塞IO——传统IO)

    一请求一应答通信

    ServerSocket和Socket

    并发量和线程数1：1

##### NIO(同步非阻塞)

    与ServerSocket和Socket相对应NIO提供了ServerSocketChannel和SocketChannel

    这两种通道都支持阻塞和非阻塞两种模式

##### AIO(异步非阻塞   NIO2.0)
    Linux Epoll          Windows IOCP
    NIO2.0的异步套接字通道是真正的异步非阻塞I/O，对应UNIX网络编程中的AIO，不需要用到Selector
    CompletionHandler接口的实现类作为操作完成的回调