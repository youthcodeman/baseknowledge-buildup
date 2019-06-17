## BeanFactory 和 FactoryBean

BeanFacotry是spring中比较原始的Factory。如XMLBeanFactory就是一种典型的BeanFactory。原始的BeanFactory无法支持spring的许多插件，
如AOP功能、Web应用等。 ApplicationContext接口,它由BeanFactory接口派生而来，ApplicationContext包含BeanFactory的所有功能，
通常建议比BeanFactory优先

### BeanFactory和FactoryBean的区别

* BeanFactory是接口，提供了OC容器最基本的形式，给具体的IOC容器的实现提供了规范，

```
public class CarFactory {
	public Car create(){
		return new Car();
	}
}
```

* FactoryBean也是接口，为IOC容器中Bean的实现提供了更加灵活的方式，FactoryBean在IOC容器的基础上给Bean的实现加上了一个简单工厂模式
和装饰模式(如果想了解装饰模式参考：修饰者模式(装饰者模式，Decoration) 我们可以在getObject()方法中灵活配置。其实在Spring源码中有
很多FactoryBean的实现类.

```
public class RunnableFactoryBean implements FactoryBean<Jeep> {

	public Jeep getObject() throws Exception {
		return new Jeep();
	}

	public Class<?> getObjectType() {
		return Jeep.class;
	}

	public boolean isSingleton() {
		return false;
	}
}

```

区别：BeanFactory是个Factory，也就是IOC容器或对象工厂，FactoryBean是个Bean。在Spring中，所有的Bean都是由BeanFactory(也就是IOC容器)
来进行管理的。但对FactoryBean而言，这个Bean不是简单的Bean，而是一个能生产或者修饰对象生成的工厂Bean,它的实现与设计模式中的工厂模式
和修饰器模式类似。