package containers.map;

/**
 * Created by eljah32 on 3/1/2019.
 */
public class Student implements Comparable {
    private String firstName;
    private String secondName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Student(String secondName, String firstName)
    {
        this.firstName=firstName;
        this.secondName=secondName;
    }

    public int compareTo(Object o) {
        return secondName.compareTo(((Student)o).getSecondName());
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
