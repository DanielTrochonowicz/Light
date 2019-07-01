package traffic.ligh.light.model;

import java.util.concurrent.Semaphore;

public class LightController {

    public static final Semaphore groupSemaphore = new Semaphore(1, true);
}
