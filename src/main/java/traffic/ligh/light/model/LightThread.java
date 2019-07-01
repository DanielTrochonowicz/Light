package traffic.ligh.light.model;

import java.util.concurrent.Semaphore;

public class LightThread extends Thread {

    private TrafficLighGroup TrafficLighGroup;
    private final Semaphore Semaphore;

    public LightThread(ThreadGroup group, String name, TrafficLighGroup lighGroup, Semaphore semaphore) {
        super(group, name);
        this.TrafficLighGroup = lighGroup;
        this.Semaphore = semaphore;
    }


    @Override
    public void run() {
        System.out.println("Group: " + this.getThreadGroup().getName() + " name: " + this.getName() + " STARTED");

        try {
            while (true) {
                Semaphore.acquire();
                System.out.println("Group: " + this.getThreadGroup().getName()
                        + " name: " + this.getName()
                        + " HAS PERMISSION to start");

                TrafficLighGroup.start(LightModels.PEDESTRIANS_MODEL);
                System.out.println("Group: " + this.getThreadGroup().getName()
                        + " name: " + this.getName()
                        + " start pedestrians light");

                Thread.sleep(2000);
                TrafficLighGroup.start(LightModels.CAR_MODEL);
                System.out.println("Group: " + this.getThreadGroup().getName()
                        + " name: " + this.getName()
                        + " start car light");

                Thread.sleep(10000);
                TrafficLighGroup.stopAll();
                System.out.println("Group: " + this.getThreadGroup().getName()
                        + " name: " + this.getName()
                        + " stop all lights");

                Semaphore.release();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.exit(-1);
        }
    }
}
