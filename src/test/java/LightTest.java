import org.junit.Assert;
import org.junit.Test;
import traffic.ligh.light.model.TrafficLigh;
import traffic.ligh.model.state.HumanLightStatesDescription;
import traffic.ligh.model.state.LightStatesDescription;
import traffic.ligh.model.state.impl.GreenLight;
import traffic.ligh.model.state.impl.RedLight;
import traffic.ligh.model.state.impl.RedYellowLight;
import traffic.ligh.model.state.impl.YellowLight;

public class LightTest {

    @Test
    public void lightState(){

        TrafficLigh light = new TrafficLigh(LightStatesDescription.RED);

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
        Assert.assertFalse(light.getState().checkCanIGo());
        Assert.assertFalse(light.getState().checkStop());
        light.nextState();

    }

    @Test
    public void humanLightTest() {
        TrafficLigh human = new TrafficLigh(HumanLightStatesDescription.RED);

        Assert.assertEquals(human.getState(), RedLight.getInstance());
        Assert.assertFalse(human.getState().checkCanIGo());
        Assert.assertTrue(human.getState().checkStop());
        human.nextState();

    }
}
