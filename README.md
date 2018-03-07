# protostuff-runtime-bruce-1.1.3
由于protostuff-runtime在生成对象的Schema时依赖对象的中字段的顺序,
在Android中由于虚拟机和服务器虚拟机存在区别，所以对象中字段的顺序会被改变，
导致服务器和Android程序中对象字段的顺序不一致,序列化数据异常。
所以需改protostuff-runtime中的代码使得字段顺序一致

<pre>
<dependency>
	<groupId>com.dyuproject.protostuff</groupId>
	<artifactId>protostuff-runtime-bruce</artifactId>
	<version>1.1.3</version>
</dependency>
</pre>

