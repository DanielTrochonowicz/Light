import org.junit.Assert;
import org.junit.Test;
import traffic.ligh.light.model.TrafficLight;
import traffic.ligh.model.state.HumanLightStatesDescription;
import traffic.ligh.model.state.LightStatesDescription;
import traffic.ligh.model.state.impl.GreenLight;
import traffic.ligh.model.state.impl.RedLight;
import traffic.ligh.model.state.impl.RedYellowLight;
import traffic.ligh.model.state.impl.YellowLight;

public class LightTest {

    @Test
    public void lightState(){

        TrafficLight light = new TrafficLight(LightStatesDescription.RED);

        Assert.assertEquals(light.getState(), RedLight.getInstance());
        Assert.assertFalse(light.getState().checkCanIGo());
        Assert.assertTrue(light.getState().checkStop());
        light.nextState();

        Assert.assertEquals(light.getState(), RedYellowLight.getInstance());
        Assert.assertFalse(light.getState().checkCanIGo());
        Assert.assertFalse(light.getState().checkStop());
        light.nextState();

        Assert.assertEquals(light.getState(), GreenLight.getInstance());
        Assert.assertTrue(light.getState().checkCanIGo());
        Assert.assertFalse(light.getState().checkStop());
        light.nextState();

        Assert.assertEquals(light.getState(), YellowLight.getInstance());
        Assert.assertTrue(light.getState().checkCanIGo());
        Assert.assertTrue(light.getState().checkStop());
        light.nextState();

    }

    @Test
    public void humanLightTest() {
        TrafficLight human = new TrafficLight(HumanLightStatesDescription.GREEN);

        Assert.assertEquals(human.getState(), HumanLightStatesDescription.GREEN.getCurrent());
        Assert.assertTrue(human.getState().checkCanIGo());
        Assert.assertFalse(human.getState().checkStop());
        human.nextState();

        Assert.assertEquals(human.getState(), HumanLightStatesDescription.GREEN_PULSE.getCurrent());
        Assert.assertTrue(human.getState().checkCanIGo());
        Assert.assertFalse(human.getState().checkStop());
        human.nextState();

        Assert.assertEquals(human.getState(), HumanLightStatesDescription.RED.getCurrent());
        Assert.assertFalse(human.getState().checkCanIGo());
        Assert.assertTrue(human.getState().checkStop());
        human.nextState();


    }
}
