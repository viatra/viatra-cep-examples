package com.rh12.tbcep.vepl.rules;

import com.google.common.collect.Lists;
import com.rh12.tbcep.vepl.jobs.InFRuleA_Job;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InF_Pattern;
import java.util.List;
import org.eclipse.viatra.cep.core.api.evm.CepActivationStates;
import org.eclipse.viatra.cep.core.api.patterns.IObservableComplexEventPattern;
import org.eclipse.viatra.cep.core.api.rules.CepJob;
import org.eclipse.viatra.cep.core.api.rules.ICepRule;
import org.eclipse.viatra.cep.core.metamodels.events.EventPattern;

@SuppressWarnings("all")
public class InFRuleA implements ICepRule {
  private List<EventPattern> eventPatterns = Lists.newArrayList();
  
  private CepJob<IObservableComplexEventPattern> job = new InFRuleA_Job(CepActivationStates.ACTIVE);
  
  public InFRuleA() {
    eventPatterns.add(new InF_Pattern());
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
