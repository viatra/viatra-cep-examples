package org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.atomic;

import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.events.InvalidModel_Event;

@SuppressWarnings("all")
public class InvalidModel_Pattern extends AtomicEventPatternImpl {
  public InvalidModel_Pattern() {
    super();
    setType(InvalidModel_Event.class.getCanonicalName());
    setId("org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.atomic.invalidmodel_pattern");
  }
  
  public boolean evaluateCheckExpression() {
    return true;
  }
}
