package org.eclipse.viatra.cep.examples.sosym.eventmodel.events;

import org.eclipse.viatra.cep.core.api.events.ParameterizableEventInstance;
import org.eclipse.viatra.cep.core.metamodels.events.EventSource;

@SuppressWarnings("all")
public class InvalidModel_Event extends ParameterizableEventInstance {
  private Object sourceElement;
  
  public InvalidModel_Event(final EventSource eventSource) {
    super(eventSource);
    getParameters().add(sourceElement);
    
  }
  
  public Object getSourceElement() {
    return this.sourceElement;
  }
  
  public void setSourceElement(final Object sourceElement) {
    this.sourceElement = sourceElement;
    getParameters().set(0, sourceElement);
  }
}
