package com.rh12.tbcep.vepl.events.queryresult;

import org.eclipse.viatra.cep.core.api.events.ParameterizableIncQueryPatternEventInstance;
import org.eclipse.viatra.cep.core.metamodels.events.EventSource;

@SuppressWarnings("all")
public class ZLeavesPlus_Event extends ParameterizableIncQueryPatternEventInstance {
  public ZLeavesPlus_Event(final EventSource eventSource) {
    super(eventSource);
    
  }
  
  @Override
  public boolean evaluateCheckExpression() {
    return true;
  }
}
