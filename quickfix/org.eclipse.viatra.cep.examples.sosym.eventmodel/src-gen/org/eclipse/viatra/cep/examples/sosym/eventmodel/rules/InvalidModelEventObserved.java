package org.eclipse.viatra.cep.examples.sosym.eventmodel.rules;

import com.google.common.collect.Lists;
import java.util.List;
import org.eclipse.incquery.runtime.evm.api.Job;
import org.eclipse.viatra.cep.core.api.evm.CepActivationStates;
import org.eclipse.viatra.cep.core.api.patterns.IObservableComplexEventPattern;
import org.eclipse.viatra.cep.core.api.rules.ICepRule;
import org.eclipse.viatra.cep.core.metamodels.events.EventPattern;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.jobs.InvalidModelEventObserved_Job;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.atomic.InvalidModel_Pattern;

@SuppressWarnings("all")
public class InvalidModelEventObserved implements ICepRule {
  private List<EventPattern> eventPatterns = Lists.newArrayList();
  
  private Job<IObservableComplexEventPattern> job = new InvalidModelEventObserved_Job(CepActivationStates.ACTIVE);
  
  public InvalidModelEventObserved() {
    eventPatterns.add(new InvalidModel_Pattern());
  }
  
  @Override
  public List<EventPattern> getEventPatterns() {
    return this.eventPatterns;
  }
  
  @Override
  public Job<IObservableComplexEventPattern> getJob() {
    return this.job;
  }
}
