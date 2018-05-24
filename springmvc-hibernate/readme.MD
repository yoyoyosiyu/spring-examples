### SpringMVC  Hibernate

这是一个使用了Spring MVC 和 Hibernate 作为演示和测试的工程项目，在这个项目里，我们测试了Spring MVC 的特性和技术，并且利用 Hibernate 作为数据库访问的工具，并且在上面校验了很多 Hibernate 的用法和用例。

为了省去为每个POJO类编写枯燥无味的setter/getter方法，我们使用了lomback, 一个在编译阶段就能为我们自动生成setter/getter方法的工具。使用lomback非常简单：

* IDE工具中把 Annotation Preprocessor 选项打开
* 工程项目中引入Lomback 的依赖
* 在需要生成setter/getter 类的声明前加上@Data注解即可。 


