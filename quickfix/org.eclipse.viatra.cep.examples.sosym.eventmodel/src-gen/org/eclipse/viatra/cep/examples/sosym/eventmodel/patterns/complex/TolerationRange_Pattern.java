package org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.complex;

import com.google.common.collect.Lists;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.atomic.InvalidModel_Pattern;

@SuppressWarnings("all")
public class TolerationRange_Pattern extends ParameterizableComplexEventPattern {
  public TolerationRange_Pattern() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new InvalidModel_Pattern(), 3, Lists.newArrayList("src"));
    setId("org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.complex.tolerationrange_pattern");
  }
}
