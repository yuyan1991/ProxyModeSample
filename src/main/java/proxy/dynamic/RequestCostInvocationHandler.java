package proxy.dynamic;

import service.IProductService;
import service.IUserService;
import service.ProductServiceImpl;
import service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RequestCostInvocationHandler implements InvocationHandler {
    private Object target;

    public RequestCostInvocationHandler(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("request")) {
            long startTime = System.currentTimeMillis();
            method.invoke(target, args);
            System.out.println("Request Cost : " + (System.currentTimeMillis() - startTime));
        }
        return null;
    }

    public static void main(String[] args) {
        IUserService userService = (IUserService) Proxy.newProxyInstance(
                                                            IUserService.class.getClassLoader(),
                                                            new Class[] {IUserService.class},
                                                            new RequestCostInvocationHandler(new UserServiceImpl()));
        userService.request();

        IProductService productService = (IProductService) Proxy.newProxyInstance(
                                                                    IProductService.class.getClassLoader(),
                                                                    new Class[] {IProductService.class},
                                                                    new RequestCostInvocationHandler(
                                                                            new ProductServiceImpl())
        );
        productService.request();
    }
}
