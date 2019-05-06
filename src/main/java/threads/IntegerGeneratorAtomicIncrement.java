package threads;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class IntegerGeneratorAtomicIncrement implements IntegerGenerator {
    AtomicInteger atomicInteger=new AtomicInteger(0);

    @Override
    public int getNext() {
        return atomicInteger.addAndGet(2);
    }
}
