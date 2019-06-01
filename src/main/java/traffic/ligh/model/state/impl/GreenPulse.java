package traffic.ligh.model.state.impl;

import traffic.ligh.model.state.TrafficLightState;

public class GreenPulse extends TrafficLightState {

    private static class SingletonHelper{
        private static final GreenPulse INSTANCE = new GreenPulse();
    }
    public static GreenPulse getInstance(){
        return SingletonHelper.INSTANCE;
    }
    public boolean checkCanIGo() {
        return true;
    }
    public boolean checkStop() {
        return false;
    }
    public void printState() {
        System.out.println("Green Pulse");
    }
}
