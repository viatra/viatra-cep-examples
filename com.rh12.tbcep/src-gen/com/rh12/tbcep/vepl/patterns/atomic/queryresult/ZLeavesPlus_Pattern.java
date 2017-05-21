package com.rh12.tbcep.vepl.patterns.atomic.queryresult;

import com.rh12.tbcep.vepl.events.queryresult.ZLeavesPlus_Event;
import org.eclipse.viatra.cep.core.metamodels.events.impl.AtomicEventPatternImpl;

@SuppressWarnings("all")
public class ZLeavesPlus_Pattern extends AtomicEventPatternImpl {
  public ZLeavesPlus_Pattern() {
    super();
    setType(ZLeavesPlus_Event.class.getCanonicalName());
    setId("com.rh12.tbcep.vepl.patterns.atomic.queryresult.zleavesplus_pattern");
  }
}
