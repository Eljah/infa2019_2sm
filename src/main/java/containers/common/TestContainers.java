package containers.common;

import containers.array.ArrayContainer;
import containers.linked.LinksContainer;
import containers.list.OwnLinkedList;
import containers.set.OwnArraySet;

import java.util.*;

public class TestContainers {
    public static void main(String[] args) {
        Container arrayContainer=new ArrayContainer(1000);
        //LinksContainer arrayContainer=new LinksContainer();
        arrayContainer.insert(100);
        arrayContainer.insert(102);
        arrayContainer.insert(103);
        arrayContainer.insert(104);
        print(arrayContainer);
        ((ArrayContainer)arrayContainer).insert(2,90);
        print(arrayContainer);

        Container linkContainer=new LinksContainer();
        linkContainer.insert(200);
        linkContainer.insert(201);
        linkContainer.insert(202);
        print(linkContainer);

        Set studentsOwnArraySet=new OwnArraySet(100);
        ((OwnArraySet) studentsOwnArraySet).display();
        System.out.println(studentsOwnArraySet.isEmpty());
        System.out.println(studentsOwnArraySet.size());

        Student student1=new Student();
        student1.setName("AAA");
        Student student2=new Student();
        student2.setName("BBB");
        Student student3=new Student();
        student3.setName("AAA");
        Object object1 = new Object();


        List<Student> studentList = new OwnLinkedList<>(student1);
        ((OwnLinkedList<Student>) studentList).display();
        System.out.println("Is empty: " + studentList.isEmpty());
        System.out.println("Size: " + studentList.size());
        studentList.add(student2);
        ((OwnLinkedList<Student>) studentList).display();
        System.out.println("Is empty: " + studentList.isEmpty());
        System.out.println("Size: " + studentList.size());
        studentList.add(student3);
        ((OwnLinkedList<Student>) studentList).display();
        System.out.println("Is empty: " + studentList.isEmpty());
        System.out.println("Size: " + studentList.size());
        /*studentList.add(object1);
        ((OwnLinkedList<Student>) studentList).display();
        System.out.println("Is empty: " + studentList.isEmpty());
        System.out.println("Size: " + studentList.size());*/

        System.out.println("INSERTED:"+studentsOwnArraySet.add(student1));
        ((OwnArraySet) studentsOwnArraySet).display();
        System.out.println("Is empty: "+studentsOwnArraySet.isEmpty());
        System.out.println(studentsOwnArraySet.size());

        System.out.println("INSERTED:"+studentsOwnArraySet.add(student2));
        ((OwnArraySet) studentsOwnArraySet).display();
        System.out.println("Is empty: "+studentsOwnArraySet.isEmpty());
        System.out.println(studentsOwnArraySet.size());

        System.out.println("INSERTED:"+studentsOwnArraySet.add(student3));
        ((OwnArraySet) studentsOwnArraySet).display();
        System.out.println("Is empty: "+studentsOwnArraySet.isEmpty());
        System.out.println(studentsOwnArraySet.size());

        System.out.println("INSERTED:"+studentsOwnArraySet.add(object1));
        ((OwnArraySet) studentsOwnArraySet).display();
        System.out.println("Is empty: "+studentsOwnArraySet.isEmpty());
        System.out.println(studentsOwnArraySet.size());


        for (Object student: studentsOwnArraySet)
        {
            System.out.println("FROM FOR ITERATOR "+(student).toString());
        }
        for (Object student: studentsOwnArraySet)
        {
            System.out.println("FROM FOR2 ITERATOR "+(student).toString());
        }
//        while (studentsOwnArraySet.iterator().hasNext())
//        {
//            System.out.println("FROM WHILE ITERATOR "+studentsOwnArraySet.iterator().next());
//        }
        Iterator iteratorStudentsOwnArraySet=studentsOwnArraySet.iterator();
        while (iteratorStudentsOwnArraySet.hasNext())
        {
            System.out.println("FROM WHILE ITERATOR "+iteratorStudentsOwnArraySet.next());
        }


            //List<Object> students=new ArrayList<Object>();
        List<Object> students=new LinkedList<Object>();
        students.add(new Student());
        students.add(new Object());
        Object fromArrayList0=students.get(0);
        Object fromArrayList1=students.get(0);

        List<Student> students2=new ArrayList<Student>();
        //List<Student> students2=new LinkedList<Student>();
        students2.add(new Student());
        Student fromArrayList2=students2.get(0);
        //students2.add(new Object());  <!-- will not work because of generic on Student

        Iterator iteratorStudents2=students2.iterator();
        while (iteratorStudents2.hasNext())
        {
            System.out.println("ITERATOR FROM ARRAY LIST "+iteratorStudents2.next());
        }

    }

    static void print(Container arrayContainer)
    {
        arrayContainer.display();
    }
}
