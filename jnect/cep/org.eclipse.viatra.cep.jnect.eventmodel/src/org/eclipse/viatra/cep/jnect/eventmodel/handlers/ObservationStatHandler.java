package org.eclipse.viatra.cep.jnect.eventmodel.handlers;

import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.viatra.cep.core.api.patterns.IObservableComplexEventPattern;
import org.eclipse.viatra.cep.core.api.rules.IActionHandler;

public class ObservationStatHandler implements IActionHandler {

    @Override
    public void handle(Activation<? extends IObservableComplexEventPattern> activation) {

        long currentTimestamp = new java.util.Date().getTime();

        if (Stats.getInstance().getMatches() == 0) {
            Stats.getInstance().setStartTime(currentTimestamp);
        }

        System.out.println("FS_FE event observed");
        Stats.getInstance().addMatch();

        if (Stats.getInstance().getRunningTime(currentTimestamp) > 30000l) {
            System.err.println(">>>ObservationStatHandler: " + Stats.getInstance().getMatches() + " matches in "
                    + Stats.getInstance().getRunningTime(currentTimestamp) + "ms.");
            Thread.currentThread().stop();
        }
    }

}
