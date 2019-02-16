package containers.linked;

public class Link {
    public long value;
    public Link link;

    public Link(long value)
    {
        this.value=value;
        this.link=null;
    }

    public boolean hasNext()
    {
        return link!=null;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Link getLink() {
        return link;
    }
}
