package com.rh12.tbcep.vepl.patterns.complex.anonymous;

import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InA_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.anonymous._AnonymousPattern_7;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class _AnonymousPattern_8 extends ParameterizableComplexEventPattern {
  public _AnonymousPattern_8() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new InA_Pattern(), 1);
    addEventPatternRefrence(new _AnonymousPattern_7(), 1);
    setId("com.rh12.tbcep.vepl.patterns.complex.anonymous._anonymouspattern_8");setEventContext(EventContext.CHRONICLE);
  }
}
