package traffic.ligh.light.model;

import traffic.ligh.model.state.HumanLightStatesDescription;
import traffic.ligh.model.state.LightStatesDescription;
import traffic.ligh.model.state.TrafficLightStateInterface;

public enum LightModels {

    CAR_MODEL(LightStatesDescription.RED),
    PEDESTRIANS_MODEL(HumanLightStatesDescription.RED);

    LightModels(TrafficLightStateInterface transposition) {
        this.lightModel = transposition;
    }

    private TrafficLightStateInterface lightModel;

    public TrafficLight getModel() {
        return new TrafficLight(lightModel);
    }

    public Class<? extends TrafficLightStateInterface> getTranspositionClass() {
        return lightModel.getClass();
    }
}
