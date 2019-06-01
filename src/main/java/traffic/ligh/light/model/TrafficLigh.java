package traffic.ligh.light.model;

import traffic.ligh.model.state.TrafficLightStateInterface;
import traffic.ligh.model.state.TrafficLightState;

public class TrafficLigh  {

    private TrafficLightStateInterface type;

    public TrafficLigh(TrafficLightStateInterface type) {
        this.type = type;
    }
    public TrafficLightState getState() {
        return type.getCurrent();
    }
    public void setState(TrafficLightState state) {
        this.type = type.getLightTypeByState(state);
    }

    public void nextState(){
        setState(type.GetNext());
    }
}
