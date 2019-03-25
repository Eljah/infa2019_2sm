package reflection;

import containers.list.OwnArrayList;
import containers.list.ShuffleContainer;
import containers.map.Student;
import containers.set.Displayeble;
import containers.set.OwnArraySet;
import containers.set.OwnLinkedSet;
import containers.streams.StudentInGroup;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;

public class GenericExampleTest {

    public static void main(String[] args) {
        String field = "aaa";

        //загрузка
        //компоновка
        //инициализация

        Displayeble displayeble = new OwnLinkedSet();
        OwnLinkedSet.justBe();
        //OwnArraySet.justBe(); //initialized on static method call
        //OwnArraySet.b=200; //initialized on static variable call
        //System.out.println(OwnArraySet.C); //not initialzed on final stativ variable call
        System.out.println(OwnArraySet.b); //initialized on static variable call
        Class displayebleClass = OwnArraySet.class;
        System.out.println(displayebleClass.isInstance(displayeble));

        Class stringClass;
        ;//= (Class<String>) field.<String>getClass();

        try {
            stringClass = Class.forName("reflection.StudentDescender");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        GenericExample<String> stringGenericExample = new GenericExample<>("aaa");
        GenericExample<StudentInGroup> studentInGroupGenericExample = new GenericExample<>(new StudentInGroup("GroupStudent", "11-806", 18, false));
        GenericExample<StudentDescender> studentInGroupGenericExample1 = new GenericExample<>(new StudentDescender("GroupStudent", "11-806", 18, false));
        GenericExample<Displayeble> studentInGroupGenericExample2 = new GenericExample<>(new OwnArraySet(100));
        GenericExample<Student> studentGenericExample = new GenericExample<>(new Student("aa", "bb"));


        Class classOfParameter = OwnLinkedSet.class;
        //Class classOfParameter = Displayeble.class;
        //Class<Displayeble> classOfParameter = Displayeble.class;
        //Class<? extends Displayeble> classOfParameter = OwnLinkedSet.class;
        //Class<? extends Displayeble> classOfParameter2 = ShuffleContainer.class;

        System.out.println(classOfParameter.getSimpleName());
        System.out.println(classOfParameter.getCanonicalName());
        System.out.println(classOfParameter.toString());
        System.out.println(classOfParameter.getTypeName());

        try {
            Method displayebleMethod=classOfParameter.getMethod("display");
            System.out.println("Before the invoke call");
            displayebleMethod.invoke(displayeble,null);
            System.out.println("After the invoke call");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Displayeble wronglyInstantiated=null;
        try {
            //wronglyInstantiated=(Displayeble) displayebleClass.newInstance();
            Constructor constructor=displayebleClass.getConstructor(int.class);
            wronglyInstantiated= (Displayeble) constructor.newInstance(100);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //Displayeble okInstantiated=new OwnArraySet(100);
        Displayeble okInstantiated=wronglyInstantiated;

        try {
            Method displayebleMethod=displayebleClass.getMethod("size");
            System.out.println("Before the invoke size call");
            int value=(int)displayebleMethod.invoke(okInstantiated,null);
            System.out.println("Value returned: "+value);
            System.out.println("After the invoke size call");
//            Method displayebleMethod1=classOfParameter.getMethod("size");
//            System.out.println("Before the invoke size call (1)");
//            int value1=(int)displayebleMethod1.invoke(okInstantiated,null);
//            System.out.println("Value returned: "+value1);
//            System.out.println("After the invoke size call (1)");

            //Method displayebleMethod2=displayebleClass.getMethod("add");
            Method displayebleMethod2=displayebleClass.getMethod("add",Object.class);
            System.out.println("Before the invoke add call");
            boolean added=(boolean)displayebleMethod2.invoke(okInstantiated,new Object());
            System.out.println("Adding object to container result:"+added);
            System.out.println("After the invoke add call");
            System.out.println("Before the invoke size call (2)");
            value=(int)displayebleMethod.invoke(okInstantiated,null);
            System.out.println("Value returned: "+value);
            System.out.println("After the invoke size call (2)");
            //Field privateCapasity=displayebleClass.getDeclaredField("capacity");
            Field privateCapasity=displayebleClass.getDeclaredField("capacity");
            privateCapasity.setAccessible(true);
            System.out.println("Capacity: "+privateCapasity.getInt(okInstantiated));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
   //     } catch (InstantiationException e) {
    //        e.printStackTrace();
       } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        //System.out.println(classOfParameter.getSuperclass().getName());
        System.out.println(Collections.unmodifiableList(Arrays.asList(classOfParameter.getInterfaces())));

        //Class newClass=new Class();
        Displayeble displayebleViaProxyCreated = (Displayeble) java.lang.reflect.Proxy.newProxyInstance(Displayeble.class.getClassLoader(), new Class[]{Displayeble.class}, new java.lang.reflect.InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String method_name = method.getName();
                Class<?>[] classes = method.getParameterTypes();

                //System.out.println("What do we have in proxy object here? "+proxy);
                System.out.println("What do we have in proxy object here? "+proxy.getClass());
                if (method_name.equals("display")) {
                    if (args == null) {
                        System.out.println("Display called without args");
                        return null;
                    } else {
                        System.out.println("Display called with args but how it is possible because of methiod signature?");
                    }
                }
                return null;
            }
        });
        displayebleViaProxyCreated.display();

        System.out.println(Displayeble.class.getClassLoader().toString());
        System.out.println(Displayeble.class.getClassLoader().getParent());
    }

}
