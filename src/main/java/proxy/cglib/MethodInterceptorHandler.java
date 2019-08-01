package proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodInterceptorHandler implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("===============Pre Message===============");
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("===============Post Message===============");
        return object;
    }
}
