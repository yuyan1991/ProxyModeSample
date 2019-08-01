package service;

public class TestService {
    public TestService() {
        System.out.println("Constructor of TestService");
    }

    public final String sayOthers(String name) {
        System.out.println("TestService.sayOthers >> " + name);
        return null;
    }

    public void sayHello() {
        System.out.println("TestService.sayHello");
    }
}
