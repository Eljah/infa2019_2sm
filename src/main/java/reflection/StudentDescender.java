package reflection;

import containers.streams.StudentInGroup;

public class StudentDescender extends StudentInGroup {
    static {
        System.out.println("StudentDescender loaded");
    }

    public StudentDescender(String name, String groupNumber, int age, boolean isGirl) {
        super(name, groupNumber, age, isGirl);
    }
}
