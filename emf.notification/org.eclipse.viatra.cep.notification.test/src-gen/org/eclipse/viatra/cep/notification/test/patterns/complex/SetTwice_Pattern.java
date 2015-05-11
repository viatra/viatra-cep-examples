package org.eclipse.viatra.cep.notification.test.patterns.complex;

import com.google.common.collect.Lists;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;
import org.eclipse.viatra.cep.emf.notification.model.patterns.atomic.SET_Pattern;

@SuppressWarnings("all")
public class SetTwice_Pattern extends ParameterizableComplexEventPattern {
  public SetTwice_Pattern() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new SET_Pattern(), 2, Lists.newArrayList("feature"));
    setId("org.eclipse.viatra.cep.notification.test.patterns.complex.settwice_pattern");
  }
}
