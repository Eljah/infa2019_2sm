package reflection;

public class RealObject implements Interface {
    @Override
    public void doSomething() {
        System.out.println("Do Something");
    }

    @Override
    public String returnSomethingElse(String arg) {
        System.out.println("Do something else "+arg
        );
        return arg;
    }
}
