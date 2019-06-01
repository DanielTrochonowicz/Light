package traffic.ligh.model.state.impl;

import traffic.ligh.model.state.TrafficLightState;

public class YellowLight extends TrafficLightState {

    private static class SingletonHelper{
        private static final YellowLight INSTANCE = new YellowLight();
    }
    public static YellowLight getInstance(){
        return SingletonHelper.INSTANCE;
    }
    public boolean checkCanIGo() {
        return false;
    }
    public boolean checkStop() {
        return false;
    }
    public void printState() {
        System.out.println("Yellow Light");
    }
}
