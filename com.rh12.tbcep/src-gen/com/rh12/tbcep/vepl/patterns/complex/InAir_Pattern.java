package com.rh12.tbcep.vepl.patterns.complex;

import com.rh12.tbcep.vepl.patterns.complex.anonymous._AnonymousPattern_5;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;
import org.eclipse.viatra.cep.core.metamodels.events.Timewindow;

@SuppressWarnings("all")
public class InAir_Pattern extends ParameterizableComplexEventPattern {
  public InAir_Pattern() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new _AnonymousPattern_5(), 1);
    						
    Timewindow timewindow = EventsFactory.eINSTANCE.createTimewindow();
    timewindow.setTime(1000);
    setTimewindow(timewindow);
    	
    setId("com.rh12.tbcep.vepl.patterns.complex.inair_pattern");setEventContext(EventContext.CHRONICLE);
  }
}
