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
        while (true) {
            int value = integerGenerator.getNext();
            if (value % 2 != 0) {
                System.out.println(value + " " + value % 2);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        IntegerGenerator integerGenerator=new IntegerGeneratorNonThreadSafe1();
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
