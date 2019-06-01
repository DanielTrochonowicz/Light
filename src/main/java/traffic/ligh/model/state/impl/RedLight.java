package traffic.ligh.model.state.impl;

import traffic.ligh.model.state.TrafficLightState;

public class RedLight extends TrafficLightState {

    private static class SingletonHelper{
        private static final RedLight INSTANCE = new RedLight();
    }
    public static RedLight getInstance(){
        return SingletonHelper.INSTANCE;
    }
    public boolean checkCanIGo() {
        return false;
    }
    public boolean checkStop() {
        return true;
    }
    public void printState() {
        System.out.println("Red Light");
    }
}
