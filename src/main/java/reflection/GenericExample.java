package reflection;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class GenericExample<T> {
    T someField;

    public GenericExample(T parameter)
    {
        //T a=new T();
        this.someField=parameter;
        Class classOfParameter=someField.getClass();
        System.out.println(classOfParameter.getSimpleName());
        System.out.println(classOfParameter.getCanonicalName());
        System.out.println(classOfParameter.toString());
        System.out.println(classOfParameter.getTypeName());

        System.out.println(classOfParameter.getSuperclass().getName());
        System.out.println(Collections.unmodifiableList(Arrays.asList(classOfParameter.getInterfaces())));

        Class asSubclass=classOfParameter.asSubclass(Object.class);
        System.out.println(asSubclass.getName());

        System.out.println(Collections.unmodifiableList(Arrays.asList(classOfParameter.getConstructors())));
        System.out.println(Collections.unmodifiableList(Arrays.asList(classOfParameter.getMethods())));
        System.out.println(Collections.unmodifiableList(Arrays.asList(classOfParameter.getFields())));
        System.out.println(Collections.unmodifiableList(Arrays.asList(classOfParameter.getDeclaredFields())));


    }
}
