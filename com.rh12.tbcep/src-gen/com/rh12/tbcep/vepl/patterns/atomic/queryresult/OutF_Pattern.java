package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.OutF_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class OutF_Pattern extends AtomicEventPatternImpl {
  public OutF_Pattern() {
    super();
    setType(OutF_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.outf_pattern");
  }
}
