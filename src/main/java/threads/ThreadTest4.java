package threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest4 implements Runnable {
    String marker;

    public ThreadTest4(String marker)
    {
        this.marker=marker;
    }

    @Override
    public void run() {
        System.out.println("ExtendedThreadStart "+marker);
        try {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("ExtendedThreadStop "+marker);

    }

    public static void main(String[] args) {

        //Executor executor= Executors.newSingleThreadExecutor();
        //Executor executor= Executors.newCachedThreadPool();
        ExecutorService executor= Executors.newFixedThreadPool(3);
        executor.execute(new ThreadTest4("Marker1"));
        executor.execute(new ThreadTest4("Marker2"));
        executor.execute(new ThreadTest4("Marker3"));
        executor.execute(new ThreadTest4("Marker4"));
        System.out.println("Before shutdown call");
        while (executor.isShutdown())
        {
            System.out.println("Waiting for shutdow");
        }
        executor.shutdown();
        //executor.execute(new ThreadTest4("Marker5"));

        System.out.println("After shutdown call");


        while (executor.isTerminated())
        {
            System.out.println("Waiting for shutdow complete");
        }

    }
}
