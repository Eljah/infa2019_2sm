package containers.common;

import containers.array.ArrayContainer;
import containers.linked.LinksContainer;
import containers.list.OwnLinkedList;
import containers.list.ShuffleContainer;
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
        System.out.println();
        System.out.println("LINKEDLIST ITERATOR START: ");

        for (Student e : studentList) {
            System.out.println(e);
        }

        System.out.println("LINKEDLIST ITERATOR END \n");

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
        students2.add(student3);
        students2.add(student2);
        students2.add(student1);
        students2.add(new Student());
        Student fromArrayList2=students2.get(0);
        //students2.add(new Object());  <!-- will not work because of generic on Student

        Iterator iteratorStudents2=students2.iterator();
        while (iteratorStudents2.hasNext())
        {
            System.out.println("ITERATOR FROM ARRAY LIST "+iteratorStudents2.next());
        }

        ShuffleContainer<Student> shuffleContainer=new ShuffleContainer<Student>(students2);
        for(Student student: shuffleContainer)
        {
            System.out.println("FOREACH ORDERED FROM SHUFFLE CONTANER "+student);
            System.out.println("HASHCODE "+student.hashCode());
        }

        for(Student student: shuffleContainer.shuffle())
        {
            System.out.println("FOREACH SHUFFLED FROM SHUFFLE CONTANER "+student);
        }

        List<Student> studentsArrayList = new ArrayList<>();
        studentsArrayList.addAll(students2);
        System.out.println("ArrayList "+studentsArrayList.toString());

        List<Student> studentsLinkedList = new LinkedList<>();
        studentsLinkedList.addAll(students2);
        System.out.println("LinkedList "+studentsLinkedList.toString());

        Set<Student> studentsHashSet = new HashSet<>();
        studentsHashSet.addAll(students2);
        System.out.println("HashSet "+studentsHashSet.toString());

        Set<Student> studentsTreeSet = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o2.getName()==null&&o1.getName()==null)
                {return 0;}
                if (o1.getName()==null)
                {return -1;}
                if (o2.getName()==null)
                {return 1;}
                return o1.getName().compareTo(o2.getName());
            }
        });
        studentsTreeSet.addAll(students2);
        System.out.println("TreeSet "+studentsTreeSet.toString());

        Set<Student> studentsLinkedHashSet = new LinkedHashSet<>();
        studentsLinkedHashSet.addAll(students2);
        System.out.println("LinkedHashSet "+studentsLinkedHashSet.toString());


    }

    static void print(Container arrayContainer)
    {
        arrayContainer.display();
    }
}
