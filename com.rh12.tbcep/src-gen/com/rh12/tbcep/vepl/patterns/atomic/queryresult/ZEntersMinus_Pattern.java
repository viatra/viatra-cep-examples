package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.ZEntersMinus_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ZEntersMinus_Pattern extends AtomicEventPatternImpl {
  public ZEntersMinus_Pattern() {
    super();
    setType(ZEntersMinus_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.zentersminus_pattern");
  }
}
