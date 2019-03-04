package containers.vararg;

import containers.common.Student;

public class VarargExample {

    public static void main(String[] args) {
        VarargExample varargExample=new VarargExample();
        varargExample.vararg(new Student(),1,2,3,3);
        varargExample.vararg(new Student(),1);
        varargExample.vararg(new Student(),new Student(),new Student());
        varargExample.vararg(new Student(),new Student[]{});
        varargExample.vararg(new Student(),new int[]{});
    }

    public void vararg(Student i,int ... varagrs)
    {
        System.out.println(varagrs.length);
        for (int inside: varagrs)
        {
            System.out.print(inside+" ");
        }
        System.out.println();
    }

    public Student vararg(Student i,Student ... students)
    {
        System.out.println("length "+students.length);
        for (Student student: students)
        {
            System.out.println("From vararg: "+student);
        }
        if (students.length>0) {
            return students[students.length - 1];
        }
        else return null;
    }

//    public Student vararg(Student i, Student ... students, int a)
//    {
//        System.out.println("length "+students.length);
//        for (Student student: students)
//        {
//            System.out.println("From vararg: "+student);
//        }
//        if (students.length>0) {
//            return students[students.length - 1];
//        }
//        else return null;
//    }

}
