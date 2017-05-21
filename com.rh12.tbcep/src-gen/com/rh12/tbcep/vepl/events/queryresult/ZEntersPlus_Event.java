package com.rh12.tbcep.vepl.events.queryresult;

import org.eclipse.viatra.cep.core.api.events.ParameterizableIncQueryPatternEventInstance;
import org.eclipse.viatra.cep.core.metamodels.events.EventSource;

/**
 * SIMPLE TEST EVENTS
 */
@SuppressWarnings("all")
public class ZEntersPlus_Event extends ParameterizableIncQueryPatternEventInstance {
  public ZEntersPlus_Event(final EventSource eventSource) {
    super(eventSource);
    
  }
  
  @Override
  public boolean evaluateCheckExpression() {
    return true;
  }
}
