## 在类中使用applicationContext的三种方式

### 通过依赖注入的方式

```java
@Component
public class User {
	
	@Autowired
	private ApplicationContext applicationContext;
	
	public void show() {
		System.out.println("user :" + applicationContext.getClass());
	}
}
```

### 实现SpringContextAware接口

```java
@Component
public class Dog implements SpringContextAware {
	private ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	
	public void show(){
		System.out.println("dog : " + applicationContext.getClass());
	}
}
```

### spring4.3 新特性，在往容器里面注册bean的时候，如果构造方法带参，spring会在容器中找已经注册的的类型中是否有满足条件的参数

```java
@Component
public class Bank {

	private ApplicationContext applicationContext;

	public Bank(ApplicationContext applicationContext, User user){
		this.applicationContext = applicationContext;
	}
	public void show(){
		System.out.println("bank : " + applicationContext.getClass());
	}
}
```