package containers.streams;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eljah32 on 3/12/2019.
 */
public class StreamsTest3 {
    public static void main(String[] args) {

        List<StudentInGroup> studentInGroupList=new ArrayList<>();
        studentInGroupList.add(new StudentInGroup("Ivanov","11-307",18,false));
        studentInGroupList.add(new StudentInGroup("Johns","11-307",19,false));
        studentInGroupList.add(new StudentInGroup("Walitov","11-307",17,false));
        studentInGroupList.add(new StudentInGroup("Kowalski","11-302",19,false));
        studentInGroupList.add(new StudentInGroup("Glauberová","11-302",19,true));
        studentInGroupList.add(new StudentInGroup("Dybenko","11-307",17,true));
        studentInGroupList.add(new StudentInGroup("Ishikawa","11-305",18,false));
        studentInGroupList.add(new StudentInGroup("Nguyen","11-305",18,false));
        studentInGroupList.add(new StudentInGroup("Chui","11-305",18,true));




    }
}
