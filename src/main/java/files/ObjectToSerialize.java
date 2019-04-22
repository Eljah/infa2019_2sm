package files;

import java.io.Serializable;

/**
 * Created by eljah32 on 4/22/2019.
 */
public class ObjectToSerialize implements Serializable {

    private static String staticExample="static";

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private boolean gender;
    //transient
    private String isResurrected;

    ObjectToSerialize(String name, int age, boolean gender)
    {
        System.out.println("Write here is the constructior was used");
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.isResurrected="yes";
        staticExample="another";
    }

    @Override
    public String toString() {
        return "Name:" + name + "\nAge: " + age + "\nGender: " + gender+ "\nIs Resurrected: " + isResurrected;
    }

}
