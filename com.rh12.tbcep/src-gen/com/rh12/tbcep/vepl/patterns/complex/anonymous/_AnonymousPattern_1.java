package com.rh12.tbcep.vepl.patterns.complex.anonymous;

import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InB_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InC_Pattern;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class _AnonymousPattern_1 extends ParameterizableComplexEventPattern {
  public _AnonymousPattern_1() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new InB_Pattern(), 1);
    addEventPatternRefrence(new InC_Pattern(), 1);
    setId("com.rh12.tbcep.vepl.patterns.complex.anonymous._anonymouspattern_1");setEventContext(EventContext.CHRONICLE);
  }
}
