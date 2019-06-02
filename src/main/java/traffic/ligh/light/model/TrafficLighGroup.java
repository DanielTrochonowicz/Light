package traffic.ligh.light.model;
import traffic.ligh.model.state.TrafficLightState;
import traffic.ligh.model.state.impl.RedLight;


public class TrafficLighGroup {

    TrafficLigh humonLight;
    TrafficLigh vehiculeLight;

    public TrafficLighGroup(TrafficLigh humonLight, TrafficLigh vehiculeLight) {
        this.humonLight = humonLight;
        this.vehiculeLight = vehiculeLight;
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
}