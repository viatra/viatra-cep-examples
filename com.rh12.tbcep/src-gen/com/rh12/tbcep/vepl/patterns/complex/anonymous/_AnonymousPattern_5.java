package com.rh12.tbcep.vepl.patterns.complex.anonymous;

import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InF_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.TakeOff_Pattern;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class _AnonymousPattern_5 extends ParameterizableComplexEventPattern {
  public _AnonymousPattern_5() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new TakeOff_Pattern(), 1);
    addEventPatternRefrence(new InF_Pattern(), 1);
    setId("com.rh12.tbcep.vepl.patterns.complex.anonymous._anonymouspattern_5");setEventContext(EventContext.CHRONICLE);
  }
}
