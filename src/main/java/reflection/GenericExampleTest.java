package reflection;

import containers.map.Student;
import containers.set.Displayeble;
import containers.set.OwnArraySet;
import containers.set.OwnLinkedSet;
import containers.streams.StudentInGroup;

import java.util.Arrays;
import java.util.Collections;

public class GenericExampleTest {

    public static void main(String[] args) {
        String field="aaa";

        Displayeble displayeble=new OwnLinkedSet();
        Class displayebleClass=OwnArraySet.class;
        System.out.println(displayebleClass.isInstance(displayeble));

        Class stringClass;;//= (Class<String>) field.<String>getClass();

        try {
            stringClass=Class.forName("reflection.StudentDescender");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        GenericExample<String> stringGenericExample=new GenericExample<>("aaa");
        GenericExample<StudentInGroup> studentInGroupGenericExample=new GenericExample<>(new StudentInGroup("GroupStudent","11-806",18,false));
        GenericExample<StudentDescender> studentInGroupGenericExample1=new GenericExample<>(new StudentDescender("GroupStudent","11-806",18,false));
        GenericExample<Displayeble> studentInGroupGenericExample2=new GenericExample<>(new OwnArraySet(100));
        GenericExample<Student> studentGenericExample=new GenericExample<>(new Student("aa","bb"));


        Class classOfParameter=Displayeble.class;
        System.out.println(classOfParameter.getSimpleName());
        System.out.println(classOfParameter.getCanonicalName());
        System.out.println(classOfParameter.toString());
        System.out.println(classOfParameter.getTypeName());

        //System.out.println(classOfParameter.getSuperclass().getName());
        System.out.println(Collections.unmodifiableList(Arrays.asList(classOfParameter.getInterfaces())));


    }
}
