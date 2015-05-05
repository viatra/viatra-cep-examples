package org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.atomic;

import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.events.ValidModel_Event;

@SuppressWarnings("all")
public class ValidModel_Pattern extends AtomicEventPatternImpl {
  public ValidModel_Pattern() {
    super();
    setType(ValidModel_Event.class.getCanonicalName());
    setId("org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.atomic.validmodel_pattern");
  }
  
  public boolean evaluateCheckExpression() {
    return true;
  }
}
