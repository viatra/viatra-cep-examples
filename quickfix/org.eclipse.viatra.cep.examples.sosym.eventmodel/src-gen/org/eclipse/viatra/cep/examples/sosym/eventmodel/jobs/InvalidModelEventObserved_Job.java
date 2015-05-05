package org.eclipse.viatra.cep.examples.sosym.eventmodel.jobs;

import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.event.ActivationState;
import org.eclipse.viatra.cep.core.api.patterns.IObservableComplexEventPattern;
import org.eclipse.viatra.cep.examples.sosym.interfaces.LoggerWrapper;

@SuppressWarnings("all")
public class InvalidModelEventObserved_Job extends Job<IObservableComplexEventPattern> {
  public InvalidModelEventObserved_Job(final ActivationState activationState) {
    super(activationState);
  }
  
  @Override
  public void execute(final Activation<? extends IObservableComplexEventPattern> activation, final Context context) {
    LoggerWrapper.debug("CEP: \'invalidModel\' event observed");
  }
  
  @Override
  public void handleError(final Activation<? extends IObservableComplexEventPattern> activation, final Exception exception, final Context context) {
    //not gonna happen
  }
}
