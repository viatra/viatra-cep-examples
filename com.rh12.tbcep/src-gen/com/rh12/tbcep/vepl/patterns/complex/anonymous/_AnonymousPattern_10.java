package com.rh12.tbcep.vepl.patterns.complex.anonymous;

import com.rh12.tbcep.vepl.patterns.atomic.queryresult.ZEntersMinus_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.ZEntersPlus_Pattern;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;

@SuppressWarnings("all")
public class _AnonymousPattern_10 extends ParameterizableComplexEventPattern {
  public _AnonymousPattern_10() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new ZEntersPlus_Pattern(), 1);
    addEventPatternRefrence(new ZEntersMinus_Pattern(), 1);
    setId("com.rh12.tbcep.vepl.patterns.complex.anonymous._anonymouspattern_10");setEventContext(EventContext.CHRONICLE);
  }
}
