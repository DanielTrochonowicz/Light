package traffic.ligh.model.state.impl;

import traffic.ligh.model.state.TrafficLightState;

public class RedYellowLight extends TrafficLightState {

    private static class SingletonHelper{
        private static final RedYellowLight INSTANCE = new RedYellowLight();
    }
    public static RedYellowLight getInstance(){
        return SingletonHelper.INSTANCE;
    }
    public boolean checkCanIGo() {
        return false;
    }
    public boolean checkStop() {
        return false;
    }
    public void printState() {
        System.out.println("Red Yellow Light");
    }
}
