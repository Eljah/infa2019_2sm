package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

public class SimpleProxyDemo
{
    public static void process(Interface iface)
    {
        iface.doSomething();
        System.out.println(iface.returnSomethingElse("argsHere"));
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
            if (args!=null&&args.length>0) {
                args[0] = args[0] + "I DO INFLUENCE";
            }
            //Object toBeReturned= method.invoke(proxied,args+"I DO INFLUENCE");
            Object toBeReturned= method.invoke(proxied,args);
            System.out.println("THIS IS AFTER CALL FROM DYNAMIC PROXY, CALLING METHOD "+method.getName());
            //if (toBeReturned instanceof String) {
            if (toBeReturned !=null) {
                return "OLOLO I CAN INFLUENCE"+toBeReturned;
            }
//            else
                return toBeReturned;
        }
    }
}
