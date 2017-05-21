package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.ZEntersPlus_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

/**
 * SIMPLE TEST EVENTS
 */
@SuppressWarnings("all")
public class ZEntersPlus_Pattern extends AtomicEventPatternImpl {
  public ZEntersPlus_Pattern() {
    super();
    setType(ZEntersPlus_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.zentersplus_pattern");
  }
}
