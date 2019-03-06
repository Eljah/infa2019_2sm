package containers.streams;

import containers.common.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {
    public static void main(String[] args) {
        final List<Student> students=new ArrayList<>();
        Student aaa=new Student();
        aaa.setName("aaa");
        Student bbb=new Student();
        bbb.setName("bbb");
        Student ccc=new Student();
        ccc.setName("ccc");
        Student cc=new Student();
        cc.setName("ccc");

        students.add(bbb);
        students.add(aaa);
        students.add(ccc);
        students.add(cc);

        for (Student student: students)
        {
            System.out.println("Print from foreach on list 1: "+student);
        }

        students.stream().peek(e -> System.out.println("Print form stream peek on stream 1: "+e)).count();

//        students=students.parallelStream().peek(e -> System.out.println("Print form stream peek on stream 2 before sorting: "+e)).sorted().
//                peek(e -> System.out.println("Print form stream peek on stream 2 after sorting: "+e)).collect(Collectors.toList());
        List<Student> students2=students.stream().peek(e -> System.out.println("Print form stream peek on stream 2 before sorting: "+e)).sorted().
                peek(e -> System.out.println("Print form stream peek on stream 2 after sorting: "+e)).collect(Collectors.toList());

        for (Student student: students2)
        {
            System.out.println("Print from foreach on list 2: "+student);
        }

        students2.stream().peek(System.out::println).count();

        //int count=0;
        int[] counterArray=new int[1];
        counterArray[0]=0;

        Stream<String> studentStream=students.stream().map(StreamsTest::studentSurname).distinct().peek((String e)->{
            counterArray[0]++;
            System.out.println("Call "+counterArray[0]+": "+e);
        });
        //System.out.println(studentStream.count());
        //System.out.println(studentStream.max(String::compareTo));
        //System.out.println(studentStream.findFirst());

        Supplier<Stream<String>> studentStreamSupplier=()-> Stream.of(students).flatMap(studentsColl->studentsColl.stream()).map((student)->student.getName()).distinct().peek((String e)->{
            counterArray[0]++;
            System.out.println("Call "+counterArray[0]+": "+e);
        });

        System.out.println("Strings longer that 0: "+studentStreamSupplier.get().anyMatch(s -> s.length()>0));
        System.out.println("Counter: "+studentStreamSupplier.get().count());
        System.out.println("Max value: "+studentStreamSupplier.get().max(String::compareTo));
        System.out.println("Find first: "+studentStreamSupplier.get().findFirst());
        System.out.println("Take only 2 first strings: "+studentStreamSupplier.get().limit(2).toString());
        System.out.println("Take only 2 first strings: "+studentStreamSupplier.get().limit(2).collect(Collectors.joining(", ")));
        System.out.println("Skip 1 string: "+studentStreamSupplier.get().skip(1).collect(Collectors.joining(", ")));
        System.out.println("Sort and skip 1 string: "+studentStreamSupplier.get().sorted().skip(1).collect(Collectors.joining(", ")));
        System.out.println("Filter by value b: "+studentStreamSupplier.get().sorted().filter(s -> s.contains("b")).collect(Collectors.joining(", ")));

        Stream<Double> doubleStream=Stream.generate(Math::random);
        System.out.println("integer random: "+doubleStream.limit(100).sorted().collect(Collectors.toList()));

//        Stream<Double> doubleStream2=Stream.generate(Math::random);
//        System.out.println("integer random not limited: "+doubleStream2.sorted().collect(Collectors.toList()));

        Stream<Integer> numberAdd3 = Stream.iterate(0, a->a+3);
        Stream<Integer> numberAdd4 = numberAdd3.limit(100);
        Stream<Integer> numberAdd5 = numberAdd4.sorted();
        System.out.println(numberAdd5.collect(Collectors.toList()));

    }


    public static String studentSurname(Student student)
    {
        return student.getName();
    }
}
