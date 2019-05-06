package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class ThreadTest8 implements Runnable {

    @Override
    public void run() {
        while (true) {
            int value = IntegerGenerator.getNext();
            if (value % 2 != 0) {
                System.out.println(value + " " + value % 2);
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Thread thread1=new Thread(new ThreadTest8());
        Thread thread2=new Thread(new ThreadTest8());
        Thread thread3=new Thread(new ThreadTest8());
        Thread thread4=new Thread(new ThreadTest8());
        Thread thread5=new Thread(new ThreadTest8());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }
}
