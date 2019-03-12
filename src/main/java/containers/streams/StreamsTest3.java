package containers.streams;

import containers.common.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by eljah32 on 3/12/2019.
 */
public class StreamsTest3 {
    public static void main(String[] args) {

        Optional<StudentInGroup> petrov=Optional.of(new StudentInGroup("Petrov",null,18,false));
        Optional<StudentInGroup> petrova=Optional.of(new StudentInGroup("Petrov","11-305",18,true));

        List<Optional<StudentInGroup>> studentInGroupList=new ArrayList<>();
        studentInGroupList.add(Optional.of(new StudentInGroup("Ivanov","11-307",18,false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Johns","11-307",19,false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Walitov","11-307",17,false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Kowalski","11-302",19,false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Glauberová","11-302",19,true)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Dybenko","11-307",17,true)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Ishikawa","11-305",18,false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Nguyen","11-305",18,false)));
        studentInGroupList.add(Optional.of(new StudentInGroup("Chui","11-305",18,true)));
        studentInGroupList.add(petrov);
        studentInGroupList.add(Optional.empty());
        studentInGroupList.add(petrova);

        String petrovasGroup=petrova.get().getGroupNumber().get(); //is it ok and null safe?
        Optional<String> petrovasGroup1=studentInGroupList.get(0).flatMap(StudentInGroup::getGroupNumber);
        Optional<String> petrovasGroup2=petrova.flatMap(StudentInGroup::getGroupNumber);
        Optional<String> petrovsGroup=petrov.flatMap(StudentInGroup::getGroupNumber);

        System.out.println(petrovasGroup);
        System.out.println(petrovasGroup1);
        System.out.println(petrovasGroup2);
        System.out.println(petrovsGroup);

        System.out.println();

        for (Optional<StudentInGroup> studentOptional: studentInGroupList)
        {
            //System.out.println(studentOptional.orElse("There is no student data")); not good idea for the object
            //System.out.println(studentOptional.orElseGet(()->"There is no student data")); not good idea for the object

            System.out.println("Common list item: "+studentOptional);
            studentOptional.ifPresent(System.out::println);
            studentOptional.ifPresent(s->System.out.println(s.getGroupNumber()));
            studentOptional.ifPresent(s->s.getGroupNumber().ifPresent(System.out::println));
            studentOptional.ifPresent(s->s.getGroupNumber().ifPresent(group->System.out.println("Group name for the student version 1: "+group)));
            studentOptional.flatMap(StudentInGroup::getGroupNumber).ifPresent(group->System.out.println("Group name for the student version 2: "+group));
        }




    }
}
