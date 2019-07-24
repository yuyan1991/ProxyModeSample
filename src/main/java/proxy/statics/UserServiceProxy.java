package proxy.statics;

import service.IUserService;
import service.UserServiceImpl;

public class UserServiceProxy implements IUserService {
    private IUserService userService;

    public UserServiceProxy(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void request() {
        long startTime = System.currentTimeMillis();
        userService.request();
        System.out.println("Request cost : " + (System.currentTimeMillis() - startTime));
    }

    public static void main(String[] args) {
        IUserService userService = new UserServiceImpl();
        UserServiceProxy userServiceProxy = new UserServiceProxy(userService);
        userServiceProxy.request();
    }
}
