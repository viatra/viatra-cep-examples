package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.InA_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

/**
 * JUMP EVENTS
 */
@SuppressWarnings("all")
public class InA_Pattern extends AtomicEventPatternImpl {
  public InA_Pattern() {
    super();
    setType(InA_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.ina_pattern");
  }
}
