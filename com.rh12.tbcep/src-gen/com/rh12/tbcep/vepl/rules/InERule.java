package com.rh12.tbcep.vepl.rules;

import com.google.common.collect.Lists;
import com.rh12.tbcep.vepl.jobs.InERule_Job;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InE_Pattern;
import java.util.List;
import org.eclipse.viatra.cep.core.api.evm.CepActivationStates;
import org.eclipse.viatra.cep.core.api.patterns.IObservableComplexEventPattern;
import org.eclipse.viatra.cep.core.api.rules.CepJob;
import org.eclipse.viatra.cep.core.api.rules.ICepRule;
import org.eclipse.viatra.cep.core.metamodels.events.EventPattern;

@SuppressWarnings("all")
public class InERule implements ICepRule {
  private List<EventPattern> eventPatterns = Lists.newArrayList();
  
  private CepJob<IObservableComplexEventPattern> job = new InERule_Job(CepActivationStates.ACTIVE);
  
  public InERule() {
    eventPatterns.add(new InE_Pattern());
  }
  
  @Override
  public List<EventPattern> getEventPatterns() {
    return this.eventPatterns;
  }
  
  @Override
  public CepJob<IObservableComplexEventPattern> getJob() {
    return this.job;
  }
}
