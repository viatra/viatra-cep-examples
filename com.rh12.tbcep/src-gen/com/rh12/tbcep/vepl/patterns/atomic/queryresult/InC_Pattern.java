package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.InC_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class InC_Pattern extends AtomicEventPatternImpl {
  public InC_Pattern() {
    super();
    setType(InC_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.inc_pattern");
  }
}
