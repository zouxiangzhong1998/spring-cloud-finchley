# 常见问题汇总

## 1. 无法下载SpringBoot 2.0.0.M3和SpringCloud Finchley.M2

解决方法：
+ 在pom.xml文件里加上如下代码（可参考product的pom.xml）：

```
<repositories>
	<repository>
		<id>spring-snapshots</id>
		<name>Spring Snapshots</name>
		<url>https://repo.spring.io/snapshot</url>
		<snapshots>
			<enabled>true</enabled>
		</snapshots>
	</repository>
	<repository>
		<id>spring-milestones</id>
		<name>Spring Milestones</name>
		<url>https://repo.spring.io/milestone</url>
		<snapshots>
			<enabled>false</enabled>
		</snapshots>
	</repository>
</repositories>

<pluginRepositories>
	<pluginRepository>
		<id>spring-snapshots</id>
		<name>Spring Snapshots</name>
		<url>https://repo.spring.io/snapshot</url>
		<snapshots>
			<enabled>true</enabled>
		</snapshots>
	</pluginRepository>
	<pluginRepository>
		<id>spring-milestones</id>
		<name>Spring Milestones</name>
		<url>https://repo.spring.io/milestone</url>
		<snapshots>
			<enabled>false</enabled>
		</snapshots>
	</pluginRepository>
</pluginRepositories>
```

+ 若在自己配置了国内maven库镜像后无法下载以上版本，则请将镜像注释掉，用maven默认的中央仓库下载（如果觉得太慢，就用科学上网）


## 2. 遇到Eureka Client无法启动的情况

解决方法：
+ 如果用的版本是SpringBoot 2.0.0.M3和SpringCloud Finchley.M2按照视频可正常启动
+ 如果是高版本无法启动时，需要在pom.xml中加入如下依赖：

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

## 3. 订单模块使用FeignClient项目不能正常启动

原因：
feign组件后来改名为openfeign了

解决方法：
+ 如果在SpringBoot 2.0.0.M3和SpringCloud Finchley.M2情况下，

在根pom.xml里加上

```
<dependencyManagement>
    <dependencies>
        <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-openfeign</artifactId>
          <version>2.0.0.M3</version>
        </dependency>
    </dependencies>
</dependencyManagement>
```

在order/pom.xml里加上

```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

+ 如果完全按照师兄视频中的版本（BUILDSNAPSHOT和openfeign），有同学提出方法：

在启动类里加上这两行（**PS：此方法可尝试一下，但不保证有效**）：
```
@ComponentScan(basePackages = "com.imooc")
@EnableFeignClients(basePackages = {"com.imooc.product.client"})
```


## 4.order项目的server模块不能正常引入product项目中的client模块
出现原因
+ 可能是因为product项目的client模块还没有打包成功，order项目的server模块不能找不到该依赖


解决办法
+ 1.先对product项目,在父模块下进行maven打包
```
mvn clean install -Dmaven.test.skip=true
```
+ 2.再进入order项目，用同样的命令再进行打包

如果对maven多模块没有经验的同学建议先看下慕课网上相关的视频课程，[链接](https://www.imooc.com/video/16354)

## 5.视频中bus章节中的springboot2.0.0.BUILD-SNAPSHOT版本
![issue](/resoures/bus-build.png)

解决办法
+ 改为以下配置  

![resolve](/resoures/bus-resovle.jpg)
