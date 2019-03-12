package containers.streams;

import containers.common.Student;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
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
        Optional<String> petrovsGroup = petrov.flatMap(StudentInGroup::getGroupNumber);

        System.out.println(petrovasGroup);
        System.out.println(petrovasGroup1);
        System.out.println(petrovasGroup2);
        System.out.println(petrovsGroup);

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


        Supplier<Stream<StudentInGroup>> studentInGroupStreamSupplier = () -> studentInGroupList.stream().map((o) -> o.orElse(new StudentInGroup(null, null, -1, false)));

        Map<String, StudentInGroup> stringStudentInGroupMap = studentInGroupStreamSupplier.get().collect(Collectors.toMap(StudentInGroup::getName, (l) -> l));
        System.out.println(stringStudentInGroupMap);

//        Map<Integer,StudentInGroup> stringStudentInGroupMap1=studentInGroupStreamSupplier.get().collect(Collectors.toMap(StudentInGroup::getAge, Function.identity()));
//        System.out.println(stringStudentInGroupMap1);

        Map<Integer, StudentInGroup> stringStudentInGroupMap1 = studentInGroupStreamSupplier.get().collect(Collectors.toMap(StudentInGroup::getAge, Function.identity(), (oldI, newI) -> newI));
        System.out.println(stringStudentInGroupMap1);

        Map<Integer, StudentInGroup> stringStudentInGroupMap2 = studentInGroupStreamSupplier.get().collect(Collectors.toMap(StudentInGroup::getAge, Function.identity(), (oldI, newI) -> oldI));
        System.out.println(stringStudentInGroupMap2);

        Map<Integer, Set<StudentInGroup>> stringStudentInGroupMap3 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.toMap(StudentInGroup::getAge, Collections::<StudentInGroup>singleton,
                (Set<StudentInGroup> a, Set<StudentInGroup> b) -> {
                    Set<StudentInGroup> studentInGroupSet = new HashSet<>();
                    studentInGroupSet.addAll(a);
                    studentInGroupSet.addAll(b);
                    return studentInGroupSet;
                }));
        System.out.println(stringStudentInGroupMap3);


        Map<Integer, Set<StudentInGroup>> stringStudentInGroupMap4 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.toMap(StudentInGroup::getAge, x -> new HashSet<>(Arrays.asList(x)),
                (x, y) -> {
                    x.addAll(y);
                    return x;
                }));
        System.out.println(stringStudentInGroupMap4);

//
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

        Map<Integer, List<StudentInGroup>> stringStudentInGroupMap9 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getAge));
        System.out.println(stringStudentInGroupMap9);

        Map<Optional<String>, List<StudentInGroup>> stringStudentInGroupMap11 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getGroupNumber));
        System.out.println(stringStudentInGroupMap11);

//        Map<String, List<StudentInGroup>> stringStudentInGroupMap10 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(StudentInGroup::getName));
//        System.out.println(stringStudentInGroupMap10);

        Map<String, List<StudentInGroup>> stringStudentInGroupMap12 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().orElse("none")));
        System.out.println(stringStudentInGroupMap12);

//        Map<String, List<StudentInGroup>> stringStudentInGroupMap13 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.groupingBy(student->student.getGroupNumber().get()));
//        System.out.println(stringStudentInGroupMap13);

        Map<String, List<StudentInGroup>> stringStudentInGroupMap14 = studentInGroupStreamSupplier.<StudentInGroup>get().filter(studentInGroup -> studentInGroup.getGroupNumber().isPresent()).collect(Collectors.groupingBy(student->student.getGroupNumber().get()));
        System.out.println(stringStudentInGroupMap14);

        Map<Integer, List<String>> stringStudentInGroupMap15 = studentInGroupStreamSupplier.<StudentInGroup>get().collect(Collectors.toMap(StudentInGroup::getAge,x -> {List toReturn=new ArrayList<String>();toReturn.add(x.getName());return toReturn;},
                (x, y) -> {
                    x.addAll(y);
                    return x;
                }));
        System.out.println(stringStudentInGroupMap15);

        studentInGroupList.add(Optional.of(new StudentInGroup("Petrov", "11-305", 18, true)));

        Map<String, List<String>> stringStudentInGroupMap16 = studentInGroupStreamSupplier.<StudentInGroup>get().map(StudentInGroup::getName).filter(s->s!=null).collect(Collectors.groupingBy(s->s.substring(0,3)));
        System.out.println(stringStudentInGroupMap16);

        Map<String, Set<String>> stringStudentInGroupMap17 = studentInGroupStreamSupplier.<StudentInGroup>get().map(StudentInGroup::getName).filter(s->s!=null).collect(Collectors.groupingBy(s->s.substring(0,3),Collectors.toSet()));
        System.out.println(stringStudentInGroupMap17);


    }
}