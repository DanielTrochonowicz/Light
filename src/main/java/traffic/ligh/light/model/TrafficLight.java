package traffic.ligh.light.model;

import traffic.ligh.model.state.TrafficLightStateInterface;
import traffic.ligh.model.state.TrafficLightState;

public class TrafficLight {

    private TrafficLightStateInterface type;

    public TrafficLight(TrafficLightStateInterface type) {
        this.type = type;
    }
    public TrafficLightState getState() {
        return type.getCurrent();
    }
    public void setState(TrafficLightState state) {
        this.type = type.getLightTypeByState(state.getClass());
    }

    public void nextState(){
        this.type = type.getLightTypeByState(type.GetNext().getClass());
    }

    public Class<? extends TrafficLightStateInterface> getTranspositionClass() {
        return this.type.getClass();
    }
}
