# protostuff-runtime-1.0.10-bruce
由于protostuff-runtime在生成对象的Schema时依赖对象的中字段的顺序,
在Android中由于虚拟机和服务器虚拟机存在区别，所以对象中字段的顺序会被改变，
导致服务器和Android程序中对象字段的顺序不一致,序列化数据异常。
所以需改protostuff-runtime中的代码使得字段顺序一致


目录  protostuff.runtime\WebContent\WEB-INF\lib 中 protostuff-runtime-1.0.10-bruce.jar
是编译好的jar包,可以在项目中与如下三个包一起直接使用,(因为protostuff-runtime依赖下面三个包)
protostuff-api-1.0.10.jar
protostuff-collectionschema-1.0.10.jar
protostuff-core-1.0.10.jar
