## 初始化和销毁bean的方法

### 实现spring容器的InitializingBean, DisposableBean接口
```
public class Cat implements InitializingBean, DisposableBean {

	public void afterPropertiesSet() throws Exception {
		System.out.println("====afterPropertiesSet=====");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("======destroy======");
	}

}
```

### 注入bean的时候定义initMethod和destroyMethod
```java
public class Dog {

	public void init(){
		System.out.println("=======init======");
	}
	
	public void destroy(){
		System.out.println("=======destroy=========");
	}
}

@Configuration
public class DogConfig {

	@Bean(initMethod="init", destroyMethod="destroy")
	public Dog createDog(){
		return new Dog();
	}
}
```


### 使用Java1.8的注解

```java
public class Animal {

	@PostConstruct
	public void initial(){
		System.out.println("--------initial-------");
	}
	
	@PreDestroy
	public void close(){
		System.out.println("--------close---------");
	}
}
```