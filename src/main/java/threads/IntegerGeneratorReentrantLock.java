package threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class IntegerGeneratorReentrantLock implements IntegerGenerator {
    int value = 0;
    Lock lock = new ReentrantLock();


    @Override
    public int getNext() {
//        lock.lock();
//        value++;
//        value++;
//        lock.unlock();
//        return value;
        lock.lock();
        try {
            value++;
            value++;
            //System.out.println("Return");
            return value;
        } finally {
            //System.out.println("Unlock");
            lock.unlock();
        }
    }
}
