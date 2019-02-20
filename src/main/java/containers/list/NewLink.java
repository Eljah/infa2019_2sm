package containers.list;

import containers.linked.Link;

public class NewLink<E> {

    private E value;
    private NewLink<E> nextLink;

    public NewLink(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public boolean hasNext() {
        return nextLink != null;
    }

    public void setNextLink(NewLink<E> link) {
        nextLink = link;
    }

    public NewLink<E> nextLink() {
        return nextLink;
    }

    @Override
    public String toString() {
        return value.toString();
    }

}
