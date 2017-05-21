package com.rh12.tbcep.vepl.patterns.complex;

import com.rh12.tbcep.vepl.patterns.complex.anonymous._AnonymousPattern_11;
import org.eclipse.viatra.cep.core.api.patterns.ParameterizableComplexEventPattern;
import org.eclipse.viatra.cep.core.metamodels.automaton.EventContext;
import org.eclipse.viatra.cep.core.metamodels.events.EventsFactory;
import org.eclipse.viatra.cep.core.metamodels.events.Timewindow;

@SuppressWarnings("all")
public class DownUpEvent_Pattern extends ParameterizableComplexEventPattern {
  public DownUpEvent_Pattern() {
    super();
    setOperator(EventsFactory.eINSTANCE.createFOLLOWS());
    
    // contained event patterns
    addEventPatternRefrence(new _AnonymousPattern_11(), 1);
    						
    Timewindow timewindow = EventsFactory.eINSTANCE.createTimewindow();
    timewindow.setTime(500);
    setTimewindow(timewindow);
    	
    setId("com.rh12.tbcep.vepl.patterns.complex.downupevent_pattern");setEventContext(EventContext.CHRONICLE);
  }
}
