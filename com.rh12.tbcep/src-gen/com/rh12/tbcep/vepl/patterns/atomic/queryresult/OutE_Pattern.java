package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.OutE_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class OutE_Pattern extends AtomicEventPatternImpl {
  public OutE_Pattern() {
    super();
    setType(OutE_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.oute_pattern");
  }
}
