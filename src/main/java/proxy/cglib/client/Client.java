package proxy.cglib.client;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import proxy.cglib.MethodInterceptorHandler;
import service.TestService;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(TestService.class);
        MethodInterceptorHandler handler = new MethodInterceptorHandler();
        enhancer.setCallback(handler);
        TestService testService = (TestService)enhancer.create();
        testService.sayHello();
        testService.sayOthers("yuyan");
    }
}
