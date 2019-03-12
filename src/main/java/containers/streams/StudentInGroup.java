package containers.streams;

import java.util.Optional;

/**
 * Created by eljah32 on 3/12/2019.
 */
public class StudentInGroup {

    private Optional<String> groupNumber;
    private String name;
    private boolean isGirl;
    private int age;

    public StudentInGroup(String name, String groupNumber, int age, boolean isGirl)
    {
        this.name=name;
        this.groupNumber=Optional.ofNullable(groupNumber);
        this.age=age;
        this.isGirl=isGirl;
    }

    public Optional<String> getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(Optional<String> groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGirl() {
        return isGirl;
    }

    public void setGirl(boolean girl) {
        isGirl = girl;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
