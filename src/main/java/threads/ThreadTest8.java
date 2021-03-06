package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class ThreadTest8 implements Runnable {

    IntegerGenerator integerGenerator;

    ThreadTest8(IntegerGenerator integerGenerator)
    {
        this.integerGenerator=integerGenerator;
    }

    @Override
    public void run() {
        int i=0;
        while (true) {
            i++;
            int value = integerGenerator.getNext();
            if (value % 2 != 0) {
                System.out.println(value + " " + value % 2);
                System.exit(-1);
            }
            if (i%1000==0)
            {
                //System.out.println(value);
            }
        }
    }

    public static void main(String[] args) {
        //IntegerGenerator integerGenerator=new IntegerGeneratorNonThreadSafe1();
        IntegerGenerator integerGenerator=new IntegerGeneratorNonThreadSafe2();
        //IntegerGenerator integerGenerator=new IntegerGeneratorNonThreadSafe3();
        //IntegerGenerator integerGenerator=new IntegerGeneratorSynchronizedMethod();
        //IntegerGenerator integerGenerator=new IntegerGeneratorAtomicIncrement();
        //IntegerGenerator integerGenerator=new IntegerGeneratorSynchonizedBlock();
        //IntegerGenerator integerGenerator=new IntegerGeneratorReentrantLock();
        Thread thread1=new Thread(new ThreadTest8(integerGenerator));
        Thread thread2=new Thread(new ThreadTest8(integerGenerator));
        Thread thread3=new Thread(new ThreadTest8(integerGenerator));
        Thread thread4=new Thread(new ThreadTest8(integerGenerator));
        Thread thread5=new Thread(new ThreadTest8(integerGenerator));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
