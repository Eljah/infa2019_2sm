package containers.list;

import java.util.*;

public class ShuffleContainer<E> implements Iterable<E> {

    private Collection<E> collection;

    public ShuffleContainer(Collection collection)
    {
        this.collection=collection;
    }

    @Override
    public Iterator<E> iterator() {
        return collection.iterator();
    }

    public Iterable<E> shuffle()
    {
        return new Iterable<E>() {
            @Override
            public Iterator<E> iterator() {
                List<E> copy=new LinkedList<>();
                copy.addAll(collection);
                Collections.shuffle(copy);
                return copy.iterator();
            }
        };
    }
}
