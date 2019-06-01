package traffic.ligh.model.state;

public interface TrafficLightStateInterface {

    TrafficLightState getCurrent();
    TrafficLightState GetNext();
    TrafficLightStateInterface getLightTypeByState (TrafficLightState now);
}