public class SortedLinksContainer {
    private Link first;

    public SortedLinksContainer(){

    }

    public void insert(long value)
    {
        Link e = new Link(value);
        Link iterator = first;
        if(first == null) {
            first = e;
        }
        else {
            if (e.value <= first.value) {
                e.setLink(first);
                first = e;
            }
            else {
                do {
                    if (e.value >= iterator.value) {
                        e.setLink(iterator.getLink());
                        iterator.setLink(e);
                        break;
                    }
                    iterator = iterator.getLink();
                }
                while (iterator.hasNext());
            }
        }
    }

    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        Link current=this.first;
        if (current!=null)
        {
            stringBuilder.append(current.value);
            stringBuilder.append(" ");
            while (current.hasNext())
            {
                stringBuilder.append(current.link.value);
                stringBuilder.append(" ");
                current=current.link;
            }
        }

        return stringBuilder.toString();
    }

    public void remove()
    {
        if (first!=null) {
            this.first = first.link;
        }
    }
}
