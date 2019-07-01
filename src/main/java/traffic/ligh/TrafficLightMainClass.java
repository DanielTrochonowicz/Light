package traffic.ligh;

import traffic.ligh.light.model.*;
import traffic.ligh.model.state.HumanLightStatesDescription;
import traffic.ligh.model.state.LightStatesDescription;

public class TrafficLightMainClass {
    public static void main(String[] args) {


        ThreadGroup horizontal = new ThreadGroup("Horizontal");
        ThreadGroup vertical = new ThreadGroup("Vertical");

        TrafficLighGroup horizontalLights = new TrafficLighGroup(LightModels.CAR_MODEL.getModel(),
                LightModels.PEDESTRIANS_MODEL.getModel());

        TrafficLighGroup verticalLights = new TrafficLighGroup(LightModels.CAR_MODEL.getModel(),
                LightModels.PEDESTRIANS_MODEL.getModel());

        LightThread firstThread = new LightThread(horizontal, "FirstThread",
                horizontalLights, LightController.groupSemaphore);

        LightThread secondThread = new LightThread(vertical, "FirstThread",
                verticalLights, LightController.groupSemaphore);

        firstThread.start();
        secondThread.start();

//        TrafficLight trafficLight = new TrafficLight(LightStatesDescription.GREEN);
//
//		trafficLight.getState().printState();
//		trafficLight.nextState();
//		trafficLight.getState().printState();
//		trafficLight.nextState();
//		trafficLight.getState().printState();
//		trafficLight.nextState();
//		trafficLight.getState().printState();
//		trafficLight.nextState();
//		trafficLight.getState().printState();
//
//		System.out.println("\n\n");

//		TrafficLight pedestrianLights = new TrafficLight(HumanLightStatesDescription.GREEN);
//		pedestrianLights.getState().printState();
//		pedestrianLights.nextState();
//		pedestrianLights.getState().printState();
//		pedestrianLights.nextState();
//		pedestrianLights.getState().printState();
//		pedestrianLights.nextState();
//		pedestrianLights.getState().printState();
//		pedestrianLights.nextState();
//		pedestrianLights.getState().printState();
//
    }
}
