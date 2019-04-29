package threads;

import java.util.concurrent.TimeUnit;

public class ThreadsTest {

    public static void main(String[] args) {

        Thread thread=Thread.currentThread();

        try {
            Thread.sleep(300);
            System.out.println("Before interruptt");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //thread.setDaemon(true);
        thread.interrupt();
        try {
            TimeUnit.MILLISECONDS.sleep(200);
            System.out.println("After interrupt");
        } catch (InterruptedException e) {
            System.out.println("After was interruped ");
            //e.printStackTrace();
        }
        finally {
            System.out.println("Finally on interruption");
        }
    }
}
