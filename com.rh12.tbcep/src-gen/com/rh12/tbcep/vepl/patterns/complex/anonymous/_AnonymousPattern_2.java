package com.rh12.tbcep.vepl.patterns.complex.anonymous;

import com.rh12.tbcep.vepl.patterns.atomic.queryresult.OutA_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.anonymous._AnonymousPattern_1;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class _AnonymousPattern_2 extends ParameterizableComplexEventPattern {
  public _AnonymousPattern_2() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new OutA_Pattern(), 1);
    addEventPatternRefrence(new _AnonymousPattern_1(), 1);
    setId("com.rh12.tbcep.vepl.patterns.complex.anonymous._anonymouspattern_2");setEventContext(EventContext.CHRONICLE);
  }
}
