package files;

import containers.common.Student;

import java.io.*;

/**
 * Created by eljah32 on 4/22/2019.
 */
public class ObjectToSerialize extends Student implements
        Serializable//,
        //Externalizable
        {

    private static String staticExample="static";

    //private static final long serialVersionUID = 1L;

    private String name;
    private int age;
    private boolean gender;
    //transient
    private String resurrected;

    //public Student student;

    //public ObjectToSerialize objectToSerialize;

    ObjectToSerialize()
    {
        System.out.println("Write here if the default constructior was used");
    };

    ObjectToSerialize(String name, int age, boolean gender)
    {
        System.out.println("Write here if the constructior was used");
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.resurrected="yes";
        staticExample="another";
        //student=new Student();
        //student.setName("Smith");
    }

    @Override
    public String toString() {
        return "Name:" + name + "\nAge: " + age + "\nGender: " + gender+ "\nIs Resurrected: " + resurrected+"\n";
        //+student.toString();
    }

//    @Override
//    public void writeExternal(ObjectOutput out) throws IOException {
//        System.out.println("Writing");
//        out.writeObject(this.name);
//    }
//
//    @Override
//    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
//        System.out.println("Reading");
//        this.name=(String)in.readObject();
//        System.out.println("Read: "+name);
//    }
}
