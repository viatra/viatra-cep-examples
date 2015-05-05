package org.eclipse.viatra.cep.examples.sosym.eventmodel.jobs;

import org.eclipse.incquery.runtime.evm.api.Activation;
import org.eclipse.incquery.runtime.evm.api.Context;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.incquery.runtime.evm.api.event.ActivationState;
import org.eclipse.viatra.cep.core.api.patterns.IObservableComplexEventPattern;
import org.eclipse.viatra.cep.examples.sosym.interfaces.DSEInterface;
import org.eclipse.viatra.cep.examples.sosym.interfaces.LoggerWrapper;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class ToleranceLimitReached_Job extends Job<IObservableComplexEventPattern> {
  public ToleranceLimitReached_Job(final ActivationState activationState) {
    super(activationState);
  }
  
  @Override
  public void execute(final Activation<? extends IObservableComplexEventPattern> activation, final Context context) {
    try {
      LoggerWrapper.debug("CEP: Toleration range reached. Invoking DSE");
      DSEInterface _instance = DSEInterface.getInstance();
      _instance.generateCandidates();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Override
  public void handleError(final Activation<? extends IObservableComplexEventPattern> activation, final Exception exception, final Context context) {
    //not gonna happen
  }
}
