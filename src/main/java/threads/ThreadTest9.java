package threads;

public class ThreadTest9 {

    public static void main(String[] args) {
        Car car1=new Car("Lada Largus");
        Thread carWashingThread=new Thread(new CarWashing(car1));
        Thread carDryingThread=new Thread(new CarDrying(car1));
        carWashingThread.start();
        carDryingThread.start();


    }
}
