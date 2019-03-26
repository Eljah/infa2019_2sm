package containers.streams;

import java.util.Optional;

/**
 * Created by eljah32 on 3/26/2019.
 */
public class Car<T> {
    Optional<T> studentInGroup;//=Optional.empty();

//    public Car(StudentInGroup studentInGroup)
//    {
//        this.studentInGroup=studentInGroup;
//    }

    public Car()
    {

    }

    @Override
    public String toString() {
        return "Car{" +
                "studentInGroup=" + studentInGroup +
                '}';
    }

    public Optional<T> getStudentInGroup() {
        return studentInGroup;
    }

    public void setStudentInGroup(T studentInGroup) {
        this.studentInGroup=Optional.of(studentInGroup);
    }
}
