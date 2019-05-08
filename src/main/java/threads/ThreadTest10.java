package threads;

public class ThreadTest10 implements Runnable {

    Integer number;
    Boolean rightChopstick;
    Boolean leftChopstick;

    ThreadTest10(Boolean right, Boolean left, Integer integer) {
        rightChopstick = right;
        leftChopstick = left;
        number=integer;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Starting occupying chopsticks "+number);
            System.out.println("Starting occupying right chopstick "+number);
            synchronized (rightChopstick) {
                System.out.println("Right chopstick occupied "+number);

                synchronized (leftChopstick) {
                    System.out.println("Left chopstick occupied "+number);
                }
                System.out.println("Left chopstick released "+number);
            }
            System.out.println("Right chopstick released "+number);
        }
    }

    public static void main(String[] args) {
        Boolean first = new Boolean(true);
        Boolean second = new Boolean(true);
        Boolean third = new Boolean(true);

        Thread thread1 = new Thread(new ThreadTest10(first, second,1));
        Thread thread2 = new Thread(new ThreadTest10(second, third,2));
        Thread thread3 = new Thread(new ThreadTest10( third, first,3));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
