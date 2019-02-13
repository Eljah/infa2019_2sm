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
}
