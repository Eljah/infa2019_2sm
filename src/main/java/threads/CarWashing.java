package threads;

public class CarWashing implements Runnable {
    Car car;

    CarWashing(Car car)
    {
        this.car=car;
    }

    @Override
    public void run() {
        try {
            while (true) {
                car.wash();
                car.washComplete();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
