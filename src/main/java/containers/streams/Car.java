package containers.streams;

/**
 * Created by eljah32 on 3/26/2019.
 */
public class Car<T> {
    T studentInGroup;

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

    public T getStudentInGroup() {
        return studentInGroup;
    }

    public void setStudentInGroup(T studentInGroup) {
        this.studentInGroup = studentInGroup;
    }
}
