package containers.set;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class OwnArraySet implements Set, Displayeble {
    //todo internal structure
    private int capacity;
    private Object[] array;

    public OwnArraySet(int max) {
        this.array = new Object[max];
        this.capacity = -1;
    }

    public int size() {
        return capacity + 1;
    }

    public boolean isEmpty() {
        if (capacity > -1) {
            return false;
        }
        return true;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator iterator() {
        return new Iterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }
        };
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public boolean add(Object value) {
        for (int i = 0; i < capacity; i++) {
            if (this.array[i].equals(value)) {
                return false;
            }
        }
        this.array[++this.capacity] = value;
        return true;
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
        for (int i = 0; i <= capacity; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
