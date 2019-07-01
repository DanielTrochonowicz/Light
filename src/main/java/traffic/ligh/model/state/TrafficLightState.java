package traffic.ligh.model.state;

import traffic.ligh.light.model.TrafficLight;

public abstract class TrafficLightState {

    public void nextState(TrafficLight t){
        TrafficLightState nextState = t.getState();
        t.setState(nextState);
    }

    public abstract boolean checkCanIGo();
    public abstract boolean checkStop();
    public abstract void printState();
}
