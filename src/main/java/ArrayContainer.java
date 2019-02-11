/**
 * Created by Ilya Evlampiev on 11.02.2019.
 */
public class ArrayContainer {

    private long[] array;
    private int capacity;

    public ArrayContainer(int max)
    {
        this.array=new long[max];
        this.capacity =-1;
    }

    public void insert(long value)
    {
        this.array[++this.capacity]=value;
    }

    public String toString()
    {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<=this.capacity;i++)
        {
            stringBuilder.append(this.array[i]);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
