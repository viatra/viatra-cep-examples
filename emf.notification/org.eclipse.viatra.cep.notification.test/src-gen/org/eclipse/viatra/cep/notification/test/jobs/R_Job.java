package org.eclipse.viatra.cep.notification.test.jobs;

import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.event.ActivationState;
import org.eclipse.viatra.cep.core.api.patterns.IObservableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.events.EventPattern;

@SuppressWarnings("all")
public class R_Job extends Job<IObservableComplexEventPattern> {
  public R_Job(final ActivationState activationState) {
    super(activationState);
  }
  
  @Override
  public void execute(final Activation<? extends IObservableComplexEventPattern> activation, final Context context) {
    IObservableComplexEventPattern _atom = activation.getAtom();
    EventPattern _observableEventPattern = _atom.getObservableEventPattern();
    String _id = _observableEventPattern.getId();
    String _format = String.format("The same feature has been set twice (%s)", _id);
    System.out.println(_format);
  }
  
  @Override
  public void handleError(final Activation<? extends IObservableComplexEventPattern> activation, final Exception exception, final Context context) {
    //not gonna happen
  }
}
