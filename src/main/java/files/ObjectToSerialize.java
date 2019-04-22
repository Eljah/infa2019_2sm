package files;

import java.io.*;

/**
 * Created by eljah32 on 4/22/2019.
 */
public class ObjectToSerialize implements
        //Serializable,
        Externalizable {

    private static String staticExample="static";

    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private boolean gender;
    //transient
    private String isResurrected;

    public ObjectToSerialize()
    {};

    ObjectToSerialize(String name, int age, boolean gender)
    {
        System.out.println("Write here if the constructior was used");
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

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Writing");
        out.writeObject(this.name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Reading");
        this.name=(String)in.readObject();
        System.out.println("Read: "+name);
    }
}
