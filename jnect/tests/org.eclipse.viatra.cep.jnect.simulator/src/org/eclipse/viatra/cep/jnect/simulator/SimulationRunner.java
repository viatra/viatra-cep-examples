package org.eclipse.viatra.cep.jnect.simulator;

import java.io.File;

import javax.xml.bind.JAXBException;

import org.jnect.core.impl.capture.persistence.Capture;
import org.jnect.core.impl.capture.persistence.PersistenceManager;
import org.junit.Test;

public class SimulationRunner {
    private final File config = new File("right_hand_loop_new.xml");
    private final int BODY_NUMBER = 4;
    private final long SPEED = 0l;

    @Test
    public void test() throws JAXBException, InterruptedException {
        Capture capture = PersistenceManager.getInstance().load(config);

        Simulator simulator = Simulator.getInstance();
        simulator.setup(capture, BODY_NUMBER, SPEED);
        simulator.simulate();
        simulator.dispose();
    }
}
