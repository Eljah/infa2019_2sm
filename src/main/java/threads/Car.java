package threads;

public class Car {
    String name;

    Car(String name)
    {
        this.name=name;
    }

    synchronized void wash() throws InterruptedException {
        System.out.println("Washing a car started: "+name);
        Thread.sleep(500);
        System.out.println("Washing a car completed: "+name);
        System.out.println("Started waiting for drying: "+name);
        wait();
        System.out.println("Waiting for drying completed: "+name);
    }

    synchronized void washComplete()
    {
        notifyAll();
    }

    synchronized void dry() throws InterruptedException
    {
        System.out.println("Drying a car started: "+name);
        Thread.sleep(500);
        System.out.println("Drying a car completed: "+name);
        System.out.println("Started waiting for washing: "+name);
        wait();
        System.out.println("Waiting for washing completed: "+name);
    }

    synchronized void dryComplete()
    {
        notifyAll();
    }

}
