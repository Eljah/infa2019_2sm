package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class IntegerGeneratorNonThreadSafe2 implements IntegerGenerator{
    //volatile
    int value=0;

    private synchronized void increase()
    {
        value++;
        value++;

    }

    public int getNext(){
           increase();
        return value;
    }
}
