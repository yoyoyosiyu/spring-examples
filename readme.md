# Spring 演示测试工程


- helloworld
    
    一个最简单的Sping程序
    
- autowired-list

    演示多个具有相同接口的实现类型的Bean通过@Autowired 来注入列表变量中
    
- constructor

    演示如何将Bean通过构造函数的参数来注入对象中
    
- import-annotation

    演示如何使用@Import, Import注解在4.2中已经升级，4.2之前只能用在接口类上，4.2之后可以用在普通的类上。通过@Import注解导入的类本身也会作为一个Bean。