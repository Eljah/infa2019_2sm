package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SimpleProxyDemo
{
    public static void process(Interface iface)
    {
        iface.doSomething();
        iface.returnSomethingElse("argsHere");
    }

    public static void main(String[] args) {
        process(new RealObject());
        process(new SimpleProxy(new RealObject()));
        //Interface dynamicProxy=(Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},new SimpleProxyDemo().new DynamicProxyHandler(new RealObject()));
        Interface dynamicProxy=(Interface) Proxy.newProxyInstance(Interface.class.getClassLoader(),new Class[]{Interface.class},new DynamicProxyHandler(new RealObject()));
        process(dynamicProxy);

    }

    static class DynamicProxyHandler implements InvocationHandler{
        private Object proxied;

        public DynamicProxyHandler(Object proxied)
        {
            this.proxied=proxied;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("THIS IS BEFORE CALL FROM DYNAMIC PROXY, CALLING METHOD "+method.getName());
            Object toBeReturned= method.invoke(proxied,args);
            System.out.println("THIS IS AFTER CALL FROM DYNAMIC PROXY, CALLING METHOD "+method.getName());
            return toBeReturned;
        }
    }
}
