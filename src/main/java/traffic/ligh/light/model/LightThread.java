package traffic.ligh.light.model;

import java.util.concurrent.Semaphore;

public class LightThread extends Thread {

    private TrafficLighGroup TrafficLighGroup;
    private final Semaphore semaphore;

    public LightThread(traffic.ligh.light.model.TrafficLighGroup trafficLighGroup, Semaphore semaphore) {
        TrafficLighGroup = trafficLighGroup;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {



    }
}
