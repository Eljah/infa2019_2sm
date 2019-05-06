package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class IntegerGeneratorSynchonizedBlock implements IntegerGenerator {
    int value=0;

    @Override
    public int getNext() {
        synchronized (this) {
            value++;
            value++;
            return value;
        }
    }
}
