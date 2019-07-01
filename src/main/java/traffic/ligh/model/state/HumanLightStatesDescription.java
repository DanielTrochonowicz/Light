package traffic.ligh.model.state;

import traffic.ligh.model.state.impl.GreenLight;
import traffic.ligh.model.state.impl.GreenPulse;
import traffic.ligh.model.state.impl.RedLight;

public enum HumanLightStatesDescription implements TrafficLightStateInterface {

    GREEN(GreenLight.getInstance(), GreenPulse.getInstance()),
    RED(RedLight.getInstance(), GreenPulse.getInstance()),
    GREEN_PULSE(GreenPulse.getInstance(), RedLight.getInstance());

    private TrafficLightState currentState;
    private TrafficLightState nextState;

    HumanLightStatesDescription(TrafficLightState currentState, TrafficLightState nextState) {
        this.currentState = currentState;
        this.nextState = nextState;
    }
    public TrafficLightState getCurrent() {
        return this.currentState;
    }
    public TrafficLightState GetNext() {
        return this.nextState;
    }

    public TrafficLightStateInterface getLightTypeByState(Class<? extends TrafficLightState> stan) {
        HumanLightStatesDescription[] value = values();
        for (HumanLightStatesDescription v : value){
            if (stan.equals(v.currentState)){
                return v;
            }
        }return null;
    }
}
