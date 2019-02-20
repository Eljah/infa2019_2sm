package containers.list;

import containers.linked.Link;
import containers.set.Displayeble;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OwnLinkedList<E>  implements List<E>, Displayeble {

    private NewLink<E> firstLink;


    public OwnLinkedList(E value) {
        firstLink = new NewLink<>(value);
    }

    @Override
    public void display() {
        StringBuilder stringBuilder =
                new StringBuilder(firstLink.getValue().toString())
                        .append(" ");
        NewLink currentLink = firstLink;
        while (currentLink.hasNext()) {
            currentLink = currentLink.nextLink();
            stringBuilder.append(currentLink).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }

    @Override
    public int size() {
        NewLink currentLink = firstLink;
        int size = currentLink != null ? 1 : 0;
        while (currentLink.hasNext()) {
            currentLink = currentLink.nextLink();
            size++;
        }

        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstLink == null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(E item) {
        NewLink<E> currentLink = firstLink;
        while (currentLink.hasNext()) {
            currentLink = currentLink.nextLink();
        }
        currentLink.setNextLink(new NewLink<E>(item));

        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return new ListIterator() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public Object next() {
                return null;
            }

            @Override
            public boolean hasPrevious() {
                return false;
            }

            @Override
            public Object previous() {
                return null;
            }

            @Override
            public int nextIndex() {
                return 0;
            }

            @Override
            public int previousIndex() {
                return 0;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Object o) {

            }

            @Override
            public void add(Object o) {

            }
        };
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}
