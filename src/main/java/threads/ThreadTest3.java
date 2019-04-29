package threads;

public class ThreadTest3 extends Thread {
   String marker;

   public ThreadTest3(String marker)
   {
       this.marker=marker;
   }

    public void run()
   {
       System.out.println("ExtendedThreadStart "+marker);
       Thread.yield();
       double a=Math.PI*Math.E*Math.PI;
       try {
           Thread.sleep(1000);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
       Thread.yield();
       System.out.println("ExtendedThreadStop "+marker);

   }

    public static void main(String[] args) {
        Thread thread=new ThreadTest3("Marker1");
        Thread thread2=new ThreadTest3("Marker2");
        Thread thread3=new ThreadTest3("Marker3");
        Thread thread4=new ThreadTest3("Marker4");

        thread4.setPriority(Thread.MAX_PRIORITY);
        thread.setPriority(Thread.MIN_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread.start();
        thread3.start();
        thread4.start();
        thread2.start();

    }

}
