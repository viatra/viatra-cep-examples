package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.ZLeavesMinus_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ZLeavesMinus_Pattern extends AtomicEventPatternImpl {
  public ZLeavesMinus_Pattern() {
    super();
    setType(ZLeavesMinus_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.zleavesminus_pattern");
  }
}
