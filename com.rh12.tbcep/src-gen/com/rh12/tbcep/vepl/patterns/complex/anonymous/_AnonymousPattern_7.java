package com.rh12.tbcep.vepl.patterns.complex.anonymous;

import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InA_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.OutA_Pattern;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class _AnonymousPattern_7 extends ParameterizableComplexEventPattern {
  public _AnonymousPattern_7() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new OutA_Pattern(), 1);
    addEventPatternRefrence(new InA_Pattern(), 1);
    setId("com.rh12.tbcep.vepl.patterns.complex.anonymous._anonymouspattern_7");setEventContext(EventContext.CHRONICLE);
  }
}
