package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class IntegerGeneratorNonThreadSafe3 implements IntegerGenerator{
    volatile
    int value=0;


    public int getNext(){
        synchronized (this) {
            value++;
            value++;
        }
        return value;
    }
}
