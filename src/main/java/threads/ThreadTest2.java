package threads;

public class ThreadTest2 implements Runnable{
    static int counter=0;
    int id;

    ThreadTest2()
    {
        id=counter++;
    }

    @Override
    public void run() {
        System.out.println("Test2 before sleep "+id);
        try {
            Thread.sleep(1000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("Ohohoho "+id);
        }
        finally {
            System.out.println("Done in finally "+id);
        }
        System.out.println("Test2 after sleep "+id);
    }

    public static void main(String[] args) {
//        Thread thread=new Thread(new ThreadTest2());
//        thread.run();
//        thread.run();
//        Thread thread2=new Thread(new ThreadTest2());
//        thread2.run();

        Thread thread=new Thread(new ThreadTest2());
        //thread.setDaemon(true);
        thread.start();
        System.out.println("1: "+thread.isAlive());
        thread.interrupt();
        System.out.println("2: "+thread.isAlive());
        //thread.start();
        Thread thread2=new Thread(new ThreadTest2());
        //thread2.setDaemon(true);
        thread2.start();
        System.out.println("3: "+thread.isAlive());
        try {
            Thread.sleep(500);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("4: "+thread.isAlive());
        System.out.println("5: "+thread2.isAlive());

    }
}
