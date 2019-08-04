package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by hzgal on 2019-8-4.
 */
public class TsetProxy {
    static interface Animal {          //接口
        void showType();
        boolean isDangers();
    }

    static class Dog implements Animal{   //实现类

        @Override
        public void showType() {
            System.out.println("狗是犬科动物");
        }

        @Override
        public boolean isDangers() {
            System.out.println("狗非常危险");
            return true;
        }
    }

    static class DogProxy implements InvocationHandler {   //代理类，必须实现InvocationHandler接口
        private Animal animal;

        public DogProxy(Animal animal) {
            this.animal = animal;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("执行了代理方法");
            return method.invoke(animal,args);
        }
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal dogProxy = (Animal) Proxy.newProxyInstance(dog.getClass().getClassLoader(),dog.getClass().getInterfaces(),new DogProxy(dog));
        dogProxy.showType();
        dogProxy.isDangers();
    }
}
