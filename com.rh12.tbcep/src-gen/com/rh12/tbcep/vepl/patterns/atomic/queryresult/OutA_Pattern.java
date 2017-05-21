package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.OutA_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class OutA_Pattern extends AtomicEventPatternImpl {
  public OutA_Pattern() {
    super();
    setType(OutA_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.outa_pattern");
  }
}
