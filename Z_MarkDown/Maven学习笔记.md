###Maven——一个项目管理工具
    Maven 使用约定优于配置的原则，应该尽可能遵守标准目录结构
    
|目录|目的|
|--------|--------|
|${basedir}	|存放pom.xml和所有的子目录|
|${basedir}/src/main/java	|项目的java源代码|
|${basedir}/src/main/resources|	项目的资源，比如说property文件，springmvc.xml|
|${basedir}/src/test/java	|项目的测试类，比如说Junit代码|
|${basedir}/src/test/resources|	测试用的资源|
|${basedir}/src/main/webapp/WEB-INF	|web应用文件目录，web项目的信息，比如存放web.xml、本地图片、jsp视图页面|
|${basedir}/target	|打包输出目录|
|${basedir}/target/classes	|编译输出目录|
|${basedir}/target/test-classes|	测试编译输出目录|
|Test.java	|Maven只会自动运行符合该命名规则的测试类|
|~/.m2/repository	|Maven默认的本地仓库目录位置|

####POM(Project Object Model 项目对象模型)

####生命周期和插件

   [生命周期](https://www.runoob.com/maven/maven-build-life-cycle.html)
   [插件](https://www.runoob.com/maven/maven-plugins.html)

    Maven有三个标准的生命周期：clean、default(build)、site
    
    每个生命周期中都包含着一系列的阶段(phase)，这些 phase 就相当于 Maven 提供的统一的接口，然后这些 phase 的具体实现由 Maven 的插件来完成。
    
    Maven构建(build)生命周期是Maven主要的生命周期，它定义了一个项目构建跟发布的过程:
        验证(validate)->编译(compile)->测试(test)->打包(package)->检查(verify)->安装(install)->部署(deploy)
    
    可以把插件插入到构建(build)生命周期的指定详细阶段(具体到某一阶段前后，如pre-clean、clean、post-clean)
    
    当一个阶段通过 Maven 命令调用时，例如 mvn compile，只有该阶段之前以及包括该阶段在内的所有阶段会被执行。

####Maven的全局配置文件   settings.xml
    位置：${user.home}\.m2\settings.xml
         D:\apache-maven-3.6.2\conf
         
####仓库——用于存放项目所需要的jar包，多个项目共享一个仓库里的相同jar包

    三种仓库：本地local、中央central、远程remote
    
    Maven查找依赖的库的顺序：本地、中央、远程
    
    本地仓库的默认位置  Default: ${user.home}/.m2/repository     例如(C:\Users\zhanx\.m2\repository)
    
    指定本地仓库位置  在settings.xml中显示指定   <localRepository>D:\develop\maven\repo</localRepository>
    
    Maven默认的中央仓库是由 Maven 社区提供的仓库，由于在墙外，下载很慢
    
    修改中央仓库
    
    使用阿里云的仓库  在settings.xml添加如下镜像
        <mirror>  
        		<id>nexus-aliyun</id>  
        		<mirrorOf>central</mirrorOf>    
        		<name>Nexus aliyun</name>  
        		<url>http://maven.aliyun.com/nexus/content/groups/public</url>  
        </mirror>
    
    添加远程仓库
            <repositories>  
                    <repository>  
                        <id>alimaven</id>  
                        <name>aliyun maven</name>  
                        <url>http://maven.aliyun.com/nexus/content/groups/public/</url>  
                        <releases>  
                            <enabled>true</enabled>  
                        </releases>  
                        <snapshots>  
                            <enabled>false</enabled>  
                        </snapshots>  
                    </repository>  
            </repositories>
        
####配置环境变量(类似JDK)
    ①创建MAVEN_HOME系统变量，指向Maven安装目录
    ②将%MAVEN_HOME%\bin;追加到PATH路径中
    
####项目打包
    mvn package
    package做了很多事情，编译，测试，打包，最后生成了一个jar包

####IDEA中的Maven
    IDEA默认带有两个版本的Maven(Maven2、Maven3)，默认选择Maven3
    可以在Settings->Build->Build Tools->Maven中修改Maven相关
    Maven 3.6.2版本和IDEA存在兼容性问题，降低到3.6.1版本就没有这个问题了
    
####[快照(snapshot)](https://www.runoob.com/maven/maven-snapshots.html)

####配置文件  profile
    可以用于切换测试环境和正式环境