package threads;

public class CarDrying implements Runnable {
    Car car;

    CarDrying(Car car)
    {
        this.car=car;
    }

    @Override
    public void run() {
        try {
            while (true) {
                car.dry();
                car.dryComplete();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
