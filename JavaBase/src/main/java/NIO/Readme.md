###Unix网络编程  5中I/O模型
    阻塞I/O模型、非阻塞I/O模型、I/O复用模型、信号驱动I/O模型、异步I/O模型(AIO)
###I/O多路复用技术
    把多个I/O的阻塞服用到同一个select的阻塞上，从而使得系统在单线程的情况下可以同时处理多个客户端请求
###主要类
    缓冲区 ByteBuffer
    管道   Pipe
    通道   Channel
    文件通道  FileChannel
    多路复用器 Selector

    所有的Channel默认都是阻塞模式
###Selector
    Selector是SelectableChannel对象的多路复用器，所有希望采用非阻塞方式进行通信的Channel都应该注册到Selector对象
    

###网络编程基本模型——C/S模型，进程间通信