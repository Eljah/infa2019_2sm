package containers.common;

import java.util.Objects;

public class Student implements Comparable {
    public String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Student)) {
            return -1;
        }

        if (this.getName() == null && ((Student)o).getName() == null) {
            return 0;
        }
        if (this.getName() == null) {
            return -1;
        }
        if (((Student)o).getName() == null) {
            return 1;
        }
        return this.getName().compareTo(((Student)o).getName());
    }
}
