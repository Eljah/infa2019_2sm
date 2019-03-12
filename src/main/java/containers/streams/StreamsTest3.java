package containers.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by eljah32 on 3/12/2019.
 */
public class StreamsTest3 {
    public static void main(String[] args) {

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




    }
}
