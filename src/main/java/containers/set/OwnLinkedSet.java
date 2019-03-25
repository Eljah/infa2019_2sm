package containers.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class OwnLinkedSet implements Set, Displayeble {
    //todo internal structure
    public static void justBe()
    {
    }

//    static {
//        System.out.println("OwnLinkedSet loaded");
//    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        //todo is empty
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public boolean add(Object o) {
        //todo uniqur instsert
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean addAll(Collection c) {
        return false;
    }

    public void clear() {

    }

    public boolean removeAll(Collection c) {
        return false;
    }

    public boolean retainAll(Collection c) {
        return false;
    }

    public boolean containsAll(Collection c) {
        return false;
    }

    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    public void display() {
        System.out.println("Here we call OwnLinkedSet display");
        //todo
    }
}
