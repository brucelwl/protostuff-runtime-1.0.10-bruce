# protostuff-runtime-bruce-1.1.3
Protobuf是Google开源的高效,跨平台的序列化工具,而protostuff是一个基于protobuf实现的序列化工具,它较于protobuf最明显的好处是,在几乎不损耗性能的情况下做到了不用我们写.proto文件来实现序列化.由于protostuff-runtime在生成类的Schema时依赖类中字段的顺序
在Android中由于虚拟机和服务器虚拟机存在区别，所以通过反射获取到类中字段的顺序会不一致，导致服务器序列化的流传输到Android后反序列化数据异常。所以需改protostuff-runtime中的代码使得字段顺序一致,基本思路就是对反射得到的字段属性进行排序
修改代码部分:RuntimeSchema类中的fill方法


### maven 依赖设置repositories


    <repositories>
		<repository>
			<id>bruce-lwl</id>
			<url>https://raw.github.com/brucelwl/maven-repo/master/</url>
			<snapshots>
				<enabled>true</enabled>
				<updatePolicy>always</updatePolicy>
			</snapshots>
		</repository>
	</repositories>


### maven 依赖设置dependencies


	<dependencies>
        <dependency>
            <groupId>com.bruce.protostuff</groupId>
            <artifactId>protostuff-runtime-bruce</artifactId>
            <version>1.1.3</version>
        </dependency>  
    </dependencies>
