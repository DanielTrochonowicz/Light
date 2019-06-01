package traffic.ligh.model.state;

import traffic.ligh.light.model.TrafficLigh;

public abstract class TrafficLightState {

    public void nextState(TrafficLigh t){
        TrafficLightState nextState = t.getState();
        t.setState(nextState);
    }

    public abstract boolean checkCanIGo();
    public abstract boolean checkStop();
    public abstract void printState();
}
