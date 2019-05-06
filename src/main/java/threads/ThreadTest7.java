package threads;

/**
 * Created by eljah32 on 5/6/2019.
 */
public class ThreadTest7 implements Runnable {
    static int counter=0;
    int id;
    LimitedResource limitedResource;

    ThreadTest7(LimitedResource limitedResource)
    {
        id=counter++;
        this.limitedResource=limitedResource;
    }

    @Override
    public void run() {
        System.out.println("Test2 before sleep "+id);
        limitedResource.use(id);
        System.out.println("Test2 after sleep "+id);
    }

    public static void main(String[] args) {

        LimitedResource limitedResource=new LimitedResource();
        Thread thread1=new Thread(new ThreadTest7(limitedResource));
        Thread thread2=new Thread(new ThreadTest7(limitedResource));
        Thread thread3=new Thread(new ThreadTest7(limitedResource));
        Thread thread4=new Thread(new ThreadTest7(limitedResource));
        Thread thread5=new Thread(new ThreadTest7(limitedResource));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();


    }
}

