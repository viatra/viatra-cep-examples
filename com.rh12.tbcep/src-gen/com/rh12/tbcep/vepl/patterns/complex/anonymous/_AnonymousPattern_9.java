package com.rh12.tbcep.vepl.patterns.complex.anonymous;

import com.rh12.tbcep.vepl.patterns.complex.Land_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.anonymous._AnonymousPattern_8;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class _AnonymousPattern_9 extends ParameterizableComplexEventPattern {
  public _AnonymousPattern_9() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new Land_Pattern(), 1);
    addEventPatternRefrence(new _AnonymousPattern_8(), 1);
    setId("com.rh12.tbcep.vepl.patterns.complex.anonymous._anonymouspattern_9");setEventContext(EventContext.CHRONICLE);
  }
}
