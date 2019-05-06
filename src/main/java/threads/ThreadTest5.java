package threads;

import java.util.concurrent.*;

public class ThreadTest5 implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Starting inside the callable");
        Thread.sleep(1000);
        System.out.println("Stopping inside the callable");
        //throw new RuntimeException("Runtime exception from inside");
        return "Success";
    }

    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<String> futureResult=executorService.submit(new ThreadTest5());
        executorService.shutdown();
        System.out.println("Print after the async calculation was strated");
        while (!futureResult.isDone())
        {
            try {
                System.out.println(futureResult.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
