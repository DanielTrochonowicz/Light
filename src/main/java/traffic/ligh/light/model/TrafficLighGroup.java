package traffic.ligh.light.model;
import traffic.ligh.model.state.TrafficLightState;
import traffic.ligh.model.state.impl.RedLight;

import java.util.Arrays;
import java.util.List;


public class TrafficLighGroup {

    TrafficLight humonLight;
    TrafficLight vehiculeLight;

    private final List<TrafficLight> lightList;

    public TrafficLighGroup(TrafficLight humonLight, TrafficLight vehiculeLight, TrafficLight... lights) {
        this.humonLight = humonLight;
        this.vehiculeLight = vehiculeLight;
        this.lightList = Arrays.asList(lights);
    }

    public TrafficLightState getStateVehiculeLight() {
        return this.vehiculeLight.getState();
    }

    public TrafficLightState getStateHumanLight() {
        return this.humonLight.getState();
    }

    public TrafficLightState setHumonLight() {

        if (getStateHumanLight() != RedLight.getInstance()) {
            while (getStateHumanLight() != RedLight.getInstance()) {
                humonLight.nextState();
            }
        }return humonLight.getState();
    }
    public TrafficLightState setVehiculeLight() {
        if (getStateVehiculeLight() != RedLight.getInstance()) {
            while (getStateVehiculeLight() != RedLight.getInstance()) {
                vehiculeLight.nextState();
            }
        }
        return vehiculeLight.getState();
    }
    public void stopAll(){
        boolean isAllRed = false;
        TrafficLightState carLight = vehiculeLight.getState();
        TrafficLightState humonLights = humonLight.getState();

        do {
            if (carLight.checkCanIGo() || !carLight.checkStop()){
                vehiculeLight.nextState();
            }
            if (humonLights.checkCanIGo() || !humonLights.checkStop()){
                humonLight.nextState();
            }
            carLight = vehiculeLight.getState();
            humonLights = vehiculeLight.getState();

            isAllRed = ((!carLight.checkCanIGo() && carLight.checkStop()))
                    && (!humonLights.checkCanIGo() && humonLights.checkStop());
        }while (!isAllRed);
    }

    /**
     * Method for stopping only one model of lights
     * @param model - LightModels instance
     */
    public void stop(LightModels model) {
        lightList.stream()
                .filter(p -> model.getTranspositionClass().equals(p.getTranspositionClass()))
                .forEach(p -> {
                    while (p.getState().checkCanIGo() || !p.getState().checkStop()) {
                        p.nextState();
                }
        });
    }
    /**
     * Method for start only one model of lights
     * @param model
     */
    public void start(LightModels model) {
        lightList.stream()
                .filter(p -> model.getTranspositionClass().equals(p.getTranspositionClass()))
                .forEach(p -> {
                    while(!p.getState().checkCanIGo() || p.getState().checkStop()) {
                        p.nextState();
               }
        });
    }
}