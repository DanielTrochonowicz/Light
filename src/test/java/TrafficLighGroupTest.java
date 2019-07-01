import org.junit.Assert;
import org.junit.Test;
import traffic.ligh.light.model.TrafficLight;
import traffic.ligh.light.model.TrafficLighGroup;
import traffic.ligh.model.state.HumanLightStatesDescription;
import traffic.ligh.model.state.LightStatesDescription;
import traffic.ligh.model.state.impl.*;

public class TrafficLighGroupTest {

    TrafficLight vehiculeLight = new TrafficLight(LightStatesDescription.RED);
    TrafficLight humonLight = new TrafficLight(HumanLightStatesDescription.GREEN);
    TrafficLighGroup grupLight = new TrafficLighGroup(humonLight, vehiculeLight);

    @Test
    public void lightStateGrup(){

        vehiculeLight.nextState();
        Assert.assertEquals(vehiculeLight.getState(), RedYellowLight.getInstance());
        Assert.assertFalse(vehiculeLight.getState().checkCanIGo());
        Assert.assertFalse(vehiculeLight.getState().checkStop());

        humonLight.nextState();
        Assert.assertEquals(humonLight.getState(), HumanLightStatesDescription.GREEN_PULSE.getCurrent());
        Assert.assertTrue(humonLight.getState().checkCanIGo());
        Assert.assertFalse(humonLight.getState().checkStop());

        Assert.assertEquals(grupLight.getStateHumanLight(), GreenPulse.getInstance());
        Assert.assertEquals(grupLight.getStateVehiculeLight(), RedYellowLight.getInstance());

    }

    @Test
    public void NextTrafficLight() {

        Assert.assertEquals(grupLight.getStateVehiculeLight(),LightStatesDescription.RED.getCurrent());
        Assert.assertEquals(grupLight.getStateHumanLight(),LightStatesDescription.GREEN.getCurrent());
    }
}
