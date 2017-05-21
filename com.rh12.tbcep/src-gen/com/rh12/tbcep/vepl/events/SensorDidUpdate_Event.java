package com.rh12.tbcep.vepl.events;

import org.eclipse.viatra.cep.core.api.events.ParameterizableEventInstance;
import org.eclipse.viatra.cep.core.metamodels.events.EventSource;

/**
 * SENSOR UPDATE EVENT
 */
@SuppressWarnings("all")
public class SensorDidUpdate_Event extends ParameterizableEventInstance {
  public SensorDidUpdate_Event(final EventSource eventSource) {
    super(eventSource);
    
  }
  
  @Override
  public boolean evaluateCheckExpression() {
    return true;
  }
}
