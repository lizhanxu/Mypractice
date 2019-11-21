Linux将所有外部设备都看作文件

对于 root 用户来说，一般情况下，文件的权限对其不起作用。

-r   递归(recursive)

权限分数
r:4
w:2
x:1

 -rwxr-xr--      
 `[4+2+1][4+0+1][4+0+0]=754`
 
 ####Linux常用命令
    getconf LONG_BIT  判断Linux系统是32位还是64位的
    lscpu    查看CPU
    
    wget 网络下载工具,下载比curl更快
    curl 文件传出工具，url请求工具
    
    curl和wget基础功能有诸多重叠，如下载等。
    curl由于可自定义各种请求参数所以在模拟web请求方面更擅长；wget由于支持ftp和Recursive所以在下载文件方面更擅长。类比的话curl是浏览器，而wget是迅雷9。
    
    netstat -ntlp    查看所有使用的端口