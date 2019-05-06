package threads;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class ThreadTest6 extends TimerTask {


    @Override
    public void run() {
        System.out.println(new Date());
        System.out.println("Starting inside the task");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date());
        System.out.println("Stopping inside the task");
    }

    public static void main(String[] args) {
        Timer timer=new Timer();
        TimerTask timerTask=new ThreadTest6();
        TimerTask timerTask0=new ThreadTest6();

        long delay = 1000L;
        timer.schedule(timerTask, delay);
        timer.schedule(timerTask0, delay+delay);

        //timer.schedule(timerTask, delay);
        System.out.println("First test initiated");

        //timerTask.cancel();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //timerTask.cancel();
        timer.cancel();
//
        System.out.println("First timer cancel initiated");
        //timer.cancel();
        //timer.schedule(timerTask, delay);
//
        System.out.println("At the fixed rate");
        System.out.println();

        Timer timer2=new Timer();
        TimerTask timerTask2=new ThreadTest6();
        delay  = 1000L;
        long period = 1000L;
        timer2.scheduleAtFixedRate(timerTask2, delay, period);

        try {
            Thread.sleep(10500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer2.purge();
        timer2.cancel();
        timerTask2.cancel();
//
//        Timer timer3=new Timer();
//        System.out.println("Task reuse");
//        System.out.println();
//
//        timer3.scheduleAtFixedRate(timerTask2, delay, period);
//
//        try {
//            Thread.sleep(1500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//

        System.out.println("At the executor service");
        System.out.println();

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        delay  = 1000L;
        period = 1000L;
        executor.scheduleAtFixedRate(timerTask2, delay, period, TimeUnit.MILLISECONDS);
        try {
            Thread.sleep(delay + period * 3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executor.shutdown();

    }
}
