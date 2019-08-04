package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hzgal on 2019-8-5.
 * newProxyInstance方法执行了以下几步操作。
 1.生成一个实现了参数interfaces里所有接口且继承了Proxy的代理类的字节码，然后用参数里的classLoader加载这个代理类。
 2.使用代理类父类的构造函数 Proxy(InvocationHandler h)来创造一个代理类的实例，将我们自定义的InvocationHandler的子类传入。
 3.返回这个代理类实例。
 */
public class JDKProxy implements InvocationHandler {

    private Object targetObject;//需要代理的目标对象

    public Object newProxy(Object targetObject) {//将目标对象传入进行代理
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), this);//返回代理对象
    }

    public Object invoke(Object proxy, Method method, Object[] args)//invoke方法
            throws Throwable {
        before();
        Object ret = null;      // 设置方法的返回值
        ret  = method.invoke(targetObject, args);       //invoke调用需要代理的方法
        after();
        return ret;
    }

    private void before() {//方法执行前
        System.out.println("方法执行前 !");
    }
    private void after() {//方法执行后
        System.out.println("方法执行后");
    }
}
