package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.OutH_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class OutH_Pattern extends AtomicEventPatternImpl {
  public OutH_Pattern() {
    super();
    setType(OutH_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.outh_pattern");
  }
}
