package reflection;

public class SimpleProxy implements Interface {
    private Interface proxied;

    public SimpleProxy(Interface proxied)
    {
        this.proxied=proxied;
    }

    @Override
    public void doSomething() {
        System.out.println("Do before do something from proxy method");
        proxied.doSomething();
        System.out.println("Do after do something from proxy method");
    }

    @Override
    public String returnSomethingElse(String arg) {
        System.out.println("Do before return somethibg else from proxy method");
        String toBeReturned=proxied.returnSomethingElse(arg);
        System.out.println("Do after return somethibg else from proxy method");
        return toBeReturned;
    }
}
