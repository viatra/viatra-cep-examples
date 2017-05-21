package com.rh12.tbcep.vepl.patterns.complex;

import com.rh12.tbcep.vepl.patterns.complex.anonymous._AnonymousPattern_10;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;
import org.eclipse.viatra.cep.core.metamodels.events.Timewindow;

@SuppressWarnings("all")
public class UpDownEvent_Pattern extends ParameterizableComplexEventPattern {
  public UpDownEvent_Pattern() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new _AnonymousPattern_10(), 1);
    						
    Timewindow timewindow = EventsFactory.eINSTANCE.createTimewindow();
    timewindow.setTime(500);
    setTimewindow(timewindow);
    	
    setId("com.rh12.tbcep.vepl.patterns.complex.updownevent_pattern");setEventContext(EventContext.CHRONICLE);
  }
}
