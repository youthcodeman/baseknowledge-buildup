## 理解spring的context
Spring有两个核心接口：BeanFactory和ApplicationContext，其中ApplicationContext是BeanFactory的子接口。他们都可代表Spring容器，
Spring容器是生成Bean实例的工厂，并且管理容器中的Bean。

Spring容器最基本的接口就是BeanFactory。BeanFactory负责配置、创建、管理Bean，他有一个子接口：ApplicationContext，因此也称之为Spring上下文。
Spring容器负责管理Bean与Bean之间的依赖关系。
 
BeanFactory接口包含以下几个基本方法：
 
 * Boolean containBean(String name):判断Spring容器是否包含id为name的Bean实例。
 
 * <T> getBean(Class<T> requiredTypr):获取Spring容器中属于requiredType类型的唯一的Bean实例。
 
 * Object getBean(String name)：返回Sprin容器中id为name的Bean实例。
 
 * <T> T getBean(String name,Class requiredType)：返回容器中id为name,并且类型为requiredType的Bean
 
 * Class <?> getType(String name)：返回容器中指定Bean实例的类型。
 
 * boolean isSingleton(String var1) throws NoSuchBeanDefinitionException; 是否单例
 
 * boolean isPrototype(String var1) throws NoSuchBeanDefinitionException; 是否多例
 
 因此，调用者只需使用getBean()方法即可获得指定Bean的引用，无须关心Bean的实例化过程。即Bean实例的创建过程完全透明。
 
 ApplicationContext作为BeanFactory的子接口，使用它作为Spring容器会更加方便。它的实现类有：FileSystemXmlApplicationContext、
 ClassPathXmlApplicationContext、AnnotationConfigApplicationContext。说白了就是配置文件的读取方式，因为spring就是利用配置文件来初始化项目的。
 第一个就是基于文件系统，第二个是基于类加载路径，第三个是基于注解。在容器加载成功以后，从容器中获取相应的bean进行操作。但是，在项目中，一般很少
 直接访问容器。