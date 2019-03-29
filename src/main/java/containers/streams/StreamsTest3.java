package containers.streams;

import containers.common.Student;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by eljah32 on 3/12/2019.
 */
public class StreamsTest3 {
    public static void main(String[] args) {

        Optional<StudentInGroup> petrov = Optional.of(new StudentInGroup("Petrov", null, 18, false));
        Optional<StudentInGroup> petrova = Optional.of(new StudentInGroup("Petrova", "11-305", 18, true));

        List<Optional<StudentInGroup>> studentInGroupList = new ArrayList<>();
        studentInGroupList.add(Optional.of(new StudentInGroup("Ivanov", "11-307", 18, false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Johns", "11-307", 19, false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Walitov", "11-307", 17, false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Kowalski", "11-302", 19, false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Glauberová", "11-302", 19, true)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Dybenko", "11-307", 17, true)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Ishikawa", "11-305", 18, false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Nguyen", "11-305", 18, false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Chui", "11-305", 18, true)));
        studentInGroupList.add(petrov);
        studentInGroupList.add(Optional.empty());
        studentInGroupList.add(petrova);

        String petrovasGroup = petrova.get().getGroupNumber().get(); //is it ok and null safe?
        Optional<String> petrovasGroup1 = studentInGroupList.get(0).flatMap(StudentInGroup::getGroupNumber);
        Optional<String> petrovasGroup2 = petrova.flatMap(StudentInGroup::getGroupNumber);
        Optional<String> petrovsGroup = petrov.flatMap((s)->{
            System.out.println("From nonempty student");return s.getGroupNumber();});
        //Optional<String> petrovsGroup = petrov.map(StudentInGroup::getGroupNumber);


        Optional<StudentInGroup> none=Optional.empty();
        //Optional<String> noneGroup = none.flatMap(StudentInGroup::getGroupNumber);
        Optional<String> noneGroup = none.flatMap((s)->{
            System.out.println("From empty student");return s.getGroupNumber();});


        System.out.println(petrovasGroup);
        System.out.println(petrovasGroup1);
        System.out.println(petrovasGroup2);
        System.out.println(petrovsGroup);

        System.out.println(noneGroup);

        System.out.println();

        for (Optional<StudentInGroup> studentOptional : studentInGroupList) {
            //System.out.println(studentOptional.orElse("There is no student data")); not good idea for the object
            //System.out.println(studentOptional.orElseGet(()->"There is no student data")); not good idea for the object

            System.out.println("Common list item: " + studentOptional);
            studentOptional.ifPresent(System.out::println);
            studentOptional.ifPresent(s -> System.out.println(s.getGroupNumber()));
            studentOptional.ifPresent(s -> s.getGroupNumber().ifPresent(System.out::println));
            studentOptional.ifPresent(s -> s.getGroupNumber().ifPresent(group -> System.out.println("Group name for the student version 1: " + group)));
            studentOptional.flatMap(StudentInGroup::getGroupNumber).ifPresent(group -> System.out.println("Group name for the student version 2: " + group));
        }
//
//
        Supplier<Stream<StudentInGroup>> studentInGroupStreamSupplier = () -> studentInGroupList.stream().map((o) -> o.orElse(new StudentInGroup(null, null, -1, false)));

        Map<String, StudentInGroup> stringStudentInGroupMap = studentInGroupStreamSupplier.get().collect(Collectors.toMap(StudentInGroup::getName, (l) -> l));
        System.out.println(stringStudentInGroupMap);

        Map<String, StudentInGroup> stringStudentInGroupMap0 = studentInGroupStreamSupplier.get().collect(Collectors.toMap(StudentInGroup::getName, Function.identity()));
        System.out.println(stringStudentInGroupMap0);
//
//        Map<Integer,StudentInGroup> stringStudentInGroupMap0=studentInGroupStreamSupplier.get().collect(Collectors.toMap(StudentInGroup::getAge, Function.identity()));
//        System.out.println(stringStudentInGroupMap0);

        Map<Integer, StudentInGroup> stringStudentInGroupMap1 = studentInGroupStreamSupplier.get().collect(Collectors.toMap(StudentInGroup::getAge, Function.identity(), (oldI, newI) -> newI));
        System.out.println(stringStudentInGroupMap1);
//
        Map<Integer, StudentInGroup> stringStudentInGroupMap2 = studentInGroupStreamSupplier.get().collect(Collectors.toMap(StudentInGroup::getAge, Function.identity(), (oldI, newI) -> oldI));
        System.out.println(stringStudentInGroupMap2);
//
        Map<Integer, Set<StudentInGroup>> stringStudentInGroupMap3 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.toMap(StudentInGroup::getAge, Collections::<StudentInGroup>singleton,
                (Set<StudentInGroup> a, Set<StudentInGroup> b) -> {
                    Set<StudentInGroup> studentInGroupSet = new HashSet<>();
                    studentInGroupSet.addAll(a);
                    studentInGroupSet.addAll(b);
                    return studentInGroupSet;
                }));
        System.out.println(stringStudentInGroupMap3);
//
//
        Map<Integer, Set<StudentInGroup>> stringStudentInGroupMap4 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.toMap(StudentInGroup::getAge, x -> new HashSet<>(Arrays.asList(x)),
                (x, y) -> {
                    x.addAll(y);
                    return x;
                }));
        System.out.println(stringStudentInGroupMap4);
//
////
//        Map<Integer, Set<StudentInGroup>> stringStudentInGroupMap6 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.toMap(StudentInGroup::getAge, Collections::<StudentInGroup>singleton,
//                (x, y) -> {
//                    x.addAll(y);
//                    return x;
//                }));
//        System.out.println(stringStudentInGroupMap6);

        Map<Integer, Set<StudentInGroup>> stringStudentInGroupMap5 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.toMap(StudentInGroup::getAge, x -> {
                    System.out.println("x: " + x);
                    return new HashSet<>();
                },
                (x, y) -> {
                    System.out.println("x: " + x + ", y: " + y);
                    x.addAll(y);
                    return x;
                }
                , HashMap::new));
        System.out.println(stringStudentInGroupMap5);
//
        Map<Integer, Set<StudentInGroup>> stringStudentInGroupMap7 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.toMap(StudentInGroup::getAge, x -> {
                    System.out.println("x: " + x);
                    return new HashSet<>(Arrays.asList(x));
                },
                (x, y) -> {
                    System.out.println("x: " + x + ", y: " + y);
                    x.addAll(y);
                    return x;
                }
                , LinkedHashMap::new));
        System.out.println(stringStudentInGroupMap7);
//
        Map<Integer, Set<StudentInGroup>> stringStudentInGroupMap8 = studentInGroupStreamSupplier.<StudentInGroup>get().parallel().collect(Collectors.toMap(StudentInGroup::getAge, x -> {
                    System.out.println("x: " + x);
                    return new HashSet<>();
                },
                (x, y) -> {
                    System.out.println("x: " + x + ", y: " + y);
                    x.addAll(y);
                    return x;
                }
                , TreeMap::new));
        System.out.println(stringStudentInGroupMap8);
//
        Map<Integer, List<StudentInGroup>> stringStudentInGroupMap9 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getAge));
        System.out.println(stringStudentInGroupMap9);
//
        Map<Optional<String>, List<StudentInGroup>> stringStudentInGroupMap11 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getGroupNumber));
        System.out.println(stringStudentInGroupMap11);
//
//        Map<String, List<StudentInGroup>> stringStudentInGroupMap10 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getName));
//        System.out.println(stringStudentInGroupMap10);
//
        Map<String, List<StudentInGroup>> stringStudentInGroupMap12 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().orElse("none")));
        System.out.println(stringStudentInGroupMap12);
//
//        Map<String, List<StudentInGroup>> stringStudentInGroupMap13 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().get()));
//        System.out.println(stringStudentInGroupMap13);
//
        Map<String, List<StudentInGroup>> stringStudentInGroupMap14 = studentInGroupStreamSupplier.<StudentInGroup>get().filter(studentInGroup -> studentInGroup.getGroupNumber().isPresent()).collect(Collectors.groupingBy(student->student.getGroupNumber().get()));
        System.out.println(stringStudentInGroupMap14);
//
        Map<Integer, List<String>> stringStudentInGroupMap15 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.toMap(StudentInGroup::getAge,x -> {List toReturn=new ArrayList<String>();toReturn.add(x.getName());return toReturn;},
                (x, y) -> {
                    x.addAll(y);
                    return x;
                }));
        System.out.println(stringStudentInGroupMap15);
//
        studentInGroupList.add(Optional.of(new StudentInGroup("Petrov", "11-305", 18, false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Petrov", "11-305", 18, false)));
//
        Map<String, List<String>> stringStudentInGroupMap16 = studentInGroupStreamSupplier.<StudentInGroup>get()
                //.peek(System.out::println)
                .map(StudentInGroup::getName).filter(s->s!=null).collect(Collectors.groupingBy(s->s.substring(0,3)));
        System.out.println(stringStudentInGroupMap16);
//
        Map<String, Set<String>> stringStudentInGroupMap17 = studentInGroupStreamSupplier.<StudentInGroup>get()
                //.peek(System.out::println)
                .map(StudentInGroup::getName).filter(s->s!=null).collect(Collectors.groupingBy(s->s.substring(0,3),Collectors.toSet()));
        System.out.println(stringStudentInGroupMap17);
//
        Map<Integer, List<StudentInGroup>> stringStudentInGroupMap18 = studentInGroupStreamSupplier.<StudentInGroup>get().filter(studentInGroup -> studentInGroup.getGroupNumber().isPresent()).collect(Collectors.groupingBy(StudentInGroup::getAge));
        System.out.println(stringStudentInGroupMap18);
//
        Map<Integer,Long> stringStudentInGroupMap19 = studentInGroupStreamSupplier.<StudentInGroup>get().filter(studentInGroup -> studentInGroup.getGroupNumber().isPresent()).collect(Collectors.groupingBy(StudentInGroup::getAge,Collectors.counting()));
        System.out.println(stringStudentInGroupMap19);
//
        Map<String,Long> stringStudentInGroupMap20 = studentInGroupStreamSupplier.<StudentInGroup>get().peek(System.out::println).filter(studentInGroup -> studentInGroup.getGroupNumber().isPresent()).collect(Collectors.groupingBy(StudentInGroup::getName,Collectors.counting()));
        System.out.println(stringStudentInGroupMap20);
//
        Map<String,Long> stringStudentInGroupMap21 = studentInGroupStreamSupplier.<StudentInGroup>get().filter(studentInGroup -> studentInGroup.getGroupNumber().isPresent()).collect(Collectors.groupingBy(student->student.getGroupNumber().get(),Collectors.counting()));
        System.out.println(stringStudentInGroupMap21);
//
        Map<String,List<String>> stringStudentInGroupMap22 = studentInGroupStreamSupplier.<StudentInGroup>get().filter(studentInGroup -> studentInGroup.getGroupNumber().isPresent()).collect(Collectors.groupingBy(student->student.getGroupNumber().get(),Collectors.mapping(StudentInGroup::getName,Collectors.toList())));
        System.out.println(stringStudentInGroupMap22);
//
        Map<String,List<String>> stringStudentInGroupMap23 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().orElse("none"),Collectors.mapping(StudentInGroup::getName,Collectors.toList())));
        System.out.println(stringStudentInGroupMap23);
//
        Map<String,Set<String>> stringStudentInGroupMap24 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().orElse("none"),Collectors.mapping(StudentInGroup::getName,Collectors.toSet())));
        System.out.println(stringStudentInGroupMap24);
//
        Map<String,Set<Integer>> stringStudentInGroupMap25 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().orElse("none"),Collectors.mapping(StudentInGroup::getAge,Collectors.toSet())));
        System.out.println(stringStudentInGroupMap25);
//
        Map<Integer,Set<String>> stringStudentInGroupMap26 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getAge,Collectors.mapping(student->student.getGroupNumber().orElse("none"),Collectors.toSet())));
        System.out.println(stringStudentInGroupMap26);
//
        Map<Integer,Map<String,Set<String>>> stringStudentInGroupMap27 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getAge,Collectors.groupingBy(student->student.getGroupNumber().orElse("none"),Collectors.mapping(StudentInGroup::getName,Collectors.toSet()))));
        System.out.println(stringStudentInGroupMap27);
//
        Map<String,Map<Integer,Set<String>>> stringStudentInGroupMap28 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().orElse("none"),Collectors.groupingBy(StudentInGroup::getAge,Collectors.mapping(StudentInGroup::getName,Collectors.toSet()))));
        System.out.println(stringStudentInGroupMap28);
//
        Map<Integer,Map<String,Long>> stringStudentInGroupMap29 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getAge,Collectors.groupingBy(student->student.getGroupNumber().orElse("none"),Collectors.mapping(StudentInGroup::getName,Collectors.counting()))));
        System.out.println(stringStudentInGroupMap29);
//
        Map<Integer,String> stringStudentInGroupMap30 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getAge,Collectors.mapping(StudentInGroup::getName,Collectors.joining(", ", "{","}"))));
        System.out.println(stringStudentInGroupMap30);
//
//        Map<Integer,String> stringStudentInGroupMap31 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getAge,Collectors.joining(", ")));
//        System.out.println(stringStudentInGroupMap31);
//
        Map<String, Double> stringStudentInGroupMap32 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().orElse("none"),Collectors.averagingDouble(StudentInGroup::getAge)));
        System.out.println(stringStudentInGroupMap32);
//
        Map<String, Double> stringStudentInGroupMap33 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().orElse("none"),Collectors.averagingInt(StudentInGroup::getAge)));
        System.out.println(stringStudentInGroupMap33);
//
        Map<String, IntSummaryStatistics> stringStudentInGroupMap34 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().orElse("none"),Collectors.summarizingInt(StudentInGroup::getAge)));
        System.out.println(stringStudentInGroupMap34);
//
        IntStream intStream=studentInGroupStreamSupplier.<StudentInGroup>get().mapToInt(StudentInGroup::getAge);
        Stream<Integer> integerStream=intStream.boxed();

        intStream=studentInGroupStreamSupplier.<StudentInGroup>get().mapToInt(StudentInGroup::getAge);
        IntSummaryStatistics intSummaryStatistics=intStream.summaryStatistics();

        IntSummaryStatistics intSummaryStatistics1=integerStream.collect(Collectors.summarizingInt(Integer::intValue));

        intStream=studentInGroupStreamSupplier.<StudentInGroup>get().mapToInt(StudentInGroup::getAge);
        integerStream=intStream.boxed();
        DoubleSummaryStatistics doubleSummaryStatistics1=integerStream.collect(Collectors.summarizingDouble(Integer::doubleValue));

        System.out.println(intSummaryStatistics);
        System.out.println(intSummaryStatistics1);
        System.out.println(doubleSummaryStatistics1);

        Map<Integer,Map<String,List<StudentInGroup>>> stringStudentInGroupMap35 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getAge,Collectors.groupingBy(student->student.getGroupNumber().orElse("none"))));
        System.out.println(stringStudentInGroupMap35);

        Map<Boolean,Map<Integer,List<StudentInGroup>>> stringStudentInGroupMap36 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.partitioningBy(StudentInGroup::isGirl,Collectors.groupingBy(StudentInGroup::getAge)));
        System.out.println(stringStudentInGroupMap36);

        //List<Car> cars=studentInGroupStreamSupplier.get().map(Car::new).collect(Collectors.toList()); //not possible if there is no StudentInGroup in constructor as argument
        List<Car> cars=studentInGroupStreamSupplier.get().map((StudentInGroup studentInGroup)->{Car car=new Car();car.setStudentInGroup(studentInGroup);return car;}).collect(Collectors.toList());
        System.out.println(cars);

        Map<Optional<StudentInGroup>, List<Car>> stringStudentInGroupMap37= studentInGroupStreamSupplier.get().map((StudentInGroup studentInGroup)->{Car car=new Car();car.setStudentInGroup(studentInGroup);return car;}).collect(Collectors.groupingBy(Car::getStudentInGroup));
        System.out.println(stringStudentInGroupMap37);
        //
        Map<String, List<Car<StudentInGroup>>> stringStudentInGroupMap38= studentInGroupStreamSupplier.get().map((StudentInGroup studentInGroup)->{Car<StudentInGroup> car=new Car<StudentInGroup>();car.setStudentInGroup(studentInGroup);return car;}).collect(Collectors.groupingBy(car->car.getStudentInGroup().map(s -> s.getName()).orElse("none")));
        System.out.println(stringStudentInGroupMap38);

        List<Integer> intList=Arrays.asList(1, 2, 3);
        Stream<Integer> intStream1=intList.stream();
        IntStream intStream2=intStream1.mapToInt(Integer::intValue);

    }
}