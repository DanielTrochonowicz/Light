package traffic.ligh.model.state;

import traffic.ligh.model.state.impl.GreenLight;
import traffic.ligh.model.state.impl.RedLight;
import traffic.ligh.model.state.impl.YellowLight;
import traffic.ligh.model.state.impl.RedYellowLight;

public enum LightStatesDescription implements TrafficLightStateInterface {

    RED(RedLight.getInstance(), RedYellowLight.getInstance()),
    GREEN(GreenLight.getInstance(), YellowLight.getInstance()),
    YELLOW(YellowLight.getInstance(), RedLight.getInstance()),
    RED_YELLOW(RedYellowLight.getInstance(), GreenLight.getInstance());

    private TrafficLightState currentState;
    private TrafficLightState nextState;

    LightStatesDescription(TrafficLightState currentState, TrafficLightState nextState) {
        this.currentState = currentState;
        this.nextState = nextState;
    }
    public TrafficLightState getCurrent() {
        return this.currentState;
    }
    public TrafficLightState GetNext() {
        return this.nextState;
    }
    public TrafficLightStateInterface getLightTypeByState(TrafficLightState stan){
        LightStatesDescription[] value = values();
        for (LightStatesDescription v : value){
            if (stan.equals(v.currentState)){
                return v;
            }
        }return null;
    }


}
