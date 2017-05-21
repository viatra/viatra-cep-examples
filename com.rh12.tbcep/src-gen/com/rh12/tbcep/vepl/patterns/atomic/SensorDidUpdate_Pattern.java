package com.rh12.tbcep.vepl.patterns.atomic;

import com.rh12.tbcep.vepl.events.SensorDidUpdate_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

/**
 * SENSOR UPDATE EVENT
 */
@SuppressWarnings("all")
public class SensorDidUpdate_Pattern extends AtomicEventPatternImpl {
  public SensorDidUpdate_Pattern() {
    super();
    setType(SensorDidUpdate_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.sensordidupdate_pattern");
  }
}
