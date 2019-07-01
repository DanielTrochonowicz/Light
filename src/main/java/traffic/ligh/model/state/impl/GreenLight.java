package traffic.ligh.model.state.impl;

import traffic.ligh.model.state.TrafficLightState;

public class GreenLight extends TrafficLightState {

    private static class SingletonHelper{
        private static final GreenLight INSTANCE = new GreenLight();
    }
    public static GreenLight getInstance(){
        return SingletonHelper.INSTANCE;
    }
    public boolean checkCanIGo() {
        return true;
    }
    public boolean checkStop() {
        return false;
    }
    public void printState() {
        System.out.println("Green Light");
    }
}
