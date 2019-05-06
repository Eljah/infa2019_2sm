package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class IntegerGeneratorSynchronizedMethod implements IntegerGenerator {
    int value=0;

    @Override
    public synchronized int getNext() {
        value++;
        value++;
        return value;
    }
}
