package containers.linked;

import containers.common.Container;

public class LinksContainer implements Container {
    private Link first;

    public LinksContainer(){

    }

    public void insert(long value)
    {
        Link link=new Link(value);
        link.link=first;
        this.first=link;
    }

    public void display() {
        System.out.println(this.toString());
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
