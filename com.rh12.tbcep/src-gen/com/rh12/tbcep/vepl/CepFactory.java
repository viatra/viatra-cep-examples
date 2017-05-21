package com.rh12.tbcep.vepl;

import com.google.common.collect.Lists;
import com.rh12.tbcep.vepl.events.SensorDidUpdate_Event;
import com.rh12.tbcep.vepl.events.queryresult.InA_Event;
import com.rh12.tbcep.vepl.events.queryresult.InB_Event;
import com.rh12.tbcep.vepl.events.queryresult.InC_Event;
import com.rh12.tbcep.vepl.events.queryresult.InD_Event;
import com.rh12.tbcep.vepl.events.queryresult.InE_Event;
import com.rh12.tbcep.vepl.events.queryresult.InF_Event;
import com.rh12.tbcep.vepl.events.queryresult.InH_Event;
import com.rh12.tbcep.vepl.events.queryresult.OutA_Event;
import com.rh12.tbcep.vepl.events.queryresult.OutB_Event;
import com.rh12.tbcep.vepl.events.queryresult.OutC_Event;
import com.rh12.tbcep.vepl.events.queryresult.OutD_Event;
import com.rh12.tbcep.vepl.events.queryresult.OutE_Event;
import com.rh12.tbcep.vepl.events.queryresult.OutF_Event;
import com.rh12.tbcep.vepl.events.queryresult.OutH_Event;
import com.rh12.tbcep.vepl.events.queryresult.ZEntersMinus_Event;
import com.rh12.tbcep.vepl.events.queryresult.ZEntersPlus_Event;
import com.rh12.tbcep.vepl.events.queryresult.ZLeavesMinus_Event;
import com.rh12.tbcep.vepl.events.queryresult.ZLeavesPlus_Event;
import com.rh12.tbcep.vepl.patterns.atomic.SensorDidUpdate_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InA_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InB_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InC_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InD_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InE_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InF_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.InH_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.OutA_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.OutB_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.OutC_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.OutD_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.OutE_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.OutF_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.OutH_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.ZEntersMinus_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.ZEntersPlus_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.ZLeavesMinus_Pattern;
import com.rh12.tbcep.vepl.patterns.atomic.queryresult.ZLeavesPlus_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.DownUpEvent_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.InAir_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.Jump_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.Land_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.Squat_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.TakeOff_Pattern;
import com.rh12.tbcep.vepl.patterns.complex.UpDownEvent_Pattern;
import com.rh12.tbcep.vepl.rules.DownUpRule;
import com.rh12.tbcep.vepl.rules.InARule;
import com.rh12.tbcep.vepl.rules.InARuleA;
import com.rh12.tbcep.vepl.rules.InAirRule;
import com.rh12.tbcep.vepl.rules.InBRule;
import com.rh12.tbcep.vepl.rules.InBRuleA;
import com.rh12.tbcep.vepl.rules.InCRule;
import com.rh12.tbcep.vepl.rules.InCRuleA;
import com.rh12.tbcep.vepl.rules.InDRule;
import com.rh12.tbcep.vepl.rules.InDRuleA;
import com.rh12.tbcep.vepl.rules.InERule;
import com.rh12.tbcep.vepl.rules.InERuleA;
import com.rh12.tbcep.vepl.rules.InFRule;
import com.rh12.tbcep.vepl.rules.InFRuleA;
import com.rh12.tbcep.vepl.rules.InHRule;
import com.rh12.tbcep.vepl.rules.InHRuleA;
import com.rh12.tbcep.vepl.rules.JumpRule;
import com.rh12.tbcep.vepl.rules.LandRule;
import com.rh12.tbcep.vepl.rules.OutARule;
import com.rh12.tbcep.vepl.rules.OutARuleA;
import com.rh12.tbcep.vepl.rules.OutBRule;
import com.rh12.tbcep.vepl.rules.OutCRule;
import com.rh12.tbcep.vepl.rules.OutDRule;
import com.rh12.tbcep.vepl.rules.OutERule;
import com.rh12.tbcep.vepl.rules.OutFRule;
import com.rh12.tbcep.vepl.rules.OutHRule;
import com.rh12.tbcep.vepl.rules.SensorDidUpdateRule;
import com.rh12.tbcep.vepl.rules.SquatRule;
import com.rh12.tbcep.vepl.rules.TakeOffRule;
import com.rh12.tbcep.vepl.rules.UpDownRule;
import com.rh12.tbcep.vepl.rules.ZMinusEnterRule;
import com.rh12.tbcep.vepl.rules.ZMinusLeaveRule;
import com.rh12.tbcep.vepl.rules.ZPlusEnterRule;
import com.rh12.tbcep.vepl.rules.ZPlusLeaveRule;
import java.util.List;
import org.eclipse.viatra.cep.core.api.rules.ICepRule;
import org.eclipse.viatra.cep.core.metamodels.events.EventSource;

@SuppressWarnings("all")
public class CepFactory {
  private static CepFactory instance;
  
  public static CepFactory getInstance() {
    if(instance == null){
    	instance = new CepFactory();
    }
    return instance;
  }
  
  /**
   * Factory method for event class {@link SensorDidUpdate_Event}.
   */
  public SensorDidUpdate_Event createSensorDidUpdate_Event(final EventSource eventSource) {
    return new SensorDidUpdate_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link SensorDidUpdate_Event}.
   */
  public SensorDidUpdate_Event createSensorDidUpdate_Event() {
    return new SensorDidUpdate_Event(null);
  }
  
  /**
   * Factory method for atomic event pattern {@link SensorDidUpdate_Pattern}.
   */
  public SensorDidUpdate_Pattern createSensorDidUpdate_Pattern() {
    return new SensorDidUpdate_Pattern();
  }
  
  /**
   * Factory method for event class {@link InA_Event}.
   */
  public InA_Event createInA_Event(final EventSource eventSource) {
    return new InA_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link InA_Event}.
   */
  public InA_Event createInA_Event() {
    return new InA_Event(null);
  }
  
  /**
   * Factory method for event class {@link OutA_Event}.
   */
  public OutA_Event createOutA_Event(final EventSource eventSource) {
    return new OutA_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link OutA_Event}.
   */
  public OutA_Event createOutA_Event() {
    return new OutA_Event(null);
  }
  
  /**
   * Factory method for event class {@link InB_Event}.
   */
  public InB_Event createInB_Event(final EventSource eventSource) {
    return new InB_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link InB_Event}.
   */
  public InB_Event createInB_Event() {
    return new InB_Event(null);
  }
  
  /**
   * Factory method for event class {@link OutB_Event}.
   */
  public OutB_Event createOutB_Event(final EventSource eventSource) {
    return new OutB_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link OutB_Event}.
   */
  public OutB_Event createOutB_Event() {
    return new OutB_Event(null);
  }
  
  /**
   * Factory method for event class {@link InC_Event}.
   */
  public InC_Event createInC_Event(final EventSource eventSource) {
    return new InC_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link InC_Event}.
   */
  public InC_Event createInC_Event() {
    return new InC_Event(null);
  }
  
  /**
   * Factory method for event class {@link OutC_Event}.
   */
  public OutC_Event createOutC_Event(final EventSource eventSource) {
    return new OutC_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link OutC_Event}.
   */
  public OutC_Event createOutC_Event() {
    return new OutC_Event(null);
  }
  
  /**
   * Factory method for event class {@link InD_Event}.
   */
  public InD_Event createInD_Event(final EventSource eventSource) {
    return new InD_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link InD_Event}.
   */
  public InD_Event createInD_Event() {
    return new InD_Event(null);
  }
  
  /**
   * Factory method for event class {@link OutD_Event}.
   */
  public OutD_Event createOutD_Event(final EventSource eventSource) {
    return new OutD_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link OutD_Event}.
   */
  public OutD_Event createOutD_Event() {
    return new OutD_Event(null);
  }
  
  /**
   * Factory method for event class {@link InE_Event}.
   */
  public InE_Event createInE_Event(final EventSource eventSource) {
    return new InE_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link InE_Event}.
   */
  public InE_Event createInE_Event() {
    return new InE_Event(null);
  }
  
  /**
   * Factory method for event class {@link OutE_Event}.
   */
  public OutE_Event createOutE_Event(final EventSource eventSource) {
    return new OutE_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link OutE_Event}.
   */
  public OutE_Event createOutE_Event() {
    return new OutE_Event(null);
  }
  
  /**
   * Factory method for event class {@link InF_Event}.
   */
  public InF_Event createInF_Event(final EventSource eventSource) {
    return new InF_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link InF_Event}.
   */
  public InF_Event createInF_Event() {
    return new InF_Event(null);
  }
  
  /**
   * Factory method for event class {@link OutF_Event}.
   */
  public OutF_Event createOutF_Event(final EventSource eventSource) {
    return new OutF_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link OutF_Event}.
   */
  public OutF_Event createOutF_Event() {
    return new OutF_Event(null);
  }
  
  /**
   * Factory method for event class {@link InH_Event}.
   */
  public InH_Event createInH_Event(final EventSource eventSource) {
    return new InH_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link InH_Event}.
   */
  public InH_Event createInH_Event() {
    return new InH_Event(null);
  }
  
  /**
   * Factory method for event class {@link OutH_Event}.
   */
  public OutH_Event createOutH_Event(final EventSource eventSource) {
    return new OutH_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link OutH_Event}.
   */
  public OutH_Event createOutH_Event() {
    return new OutH_Event(null);
  }
  
  /**
   * Factory method for event class {@link ZEntersPlus_Event}.
   */
  public ZEntersPlus_Event createZEntersPlus_Event(final EventSource eventSource) {
    return new ZEntersPlus_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link ZEntersPlus_Event}.
   */
  public ZEntersPlus_Event createZEntersPlus_Event() {
    return new ZEntersPlus_Event(null);
  }
  
  /**
   * Factory method for event class {@link ZEntersMinus_Event}.
   */
  public ZEntersMinus_Event createZEntersMinus_Event(final EventSource eventSource) {
    return new ZEntersMinus_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link ZEntersMinus_Event}.
   */
  public ZEntersMinus_Event createZEntersMinus_Event() {
    return new ZEntersMinus_Event(null);
  }
  
  /**
   * Factory method for event class {@link ZLeavesPlus_Event}.
   */
  public ZLeavesPlus_Event createZLeavesPlus_Event(final EventSource eventSource) {
    return new ZLeavesPlus_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link ZLeavesPlus_Event}.
   */
  public ZLeavesPlus_Event createZLeavesPlus_Event() {
    return new ZLeavesPlus_Event(null);
  }
  
  /**
   * Factory method for event class {@link ZLeavesMinus_Event}.
   */
  public ZLeavesMinus_Event createZLeavesMinus_Event(final EventSource eventSource) {
    return new ZLeavesMinus_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link ZLeavesMinus_Event}.
   */
  public ZLeavesMinus_Event createZLeavesMinus_Event() {
    return new ZLeavesMinus_Event(null);
  }
  
  /**
   * Factory method for atomic query result event pattern {@link InA_Pattern}.
   */
  public InA_Pattern createInA_Pattern() {
    return new InA_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link OutA_Pattern}.
   */
  public OutA_Pattern createOutA_Pattern() {
    return new OutA_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link InB_Pattern}.
   */
  public InB_Pattern createInB_Pattern() {
    return new InB_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link OutB_Pattern}.
   */
  public OutB_Pattern createOutB_Pattern() {
    return new OutB_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link InC_Pattern}.
   */
  public InC_Pattern createInC_Pattern() {
    return new InC_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link OutC_Pattern}.
   */
  public OutC_Pattern createOutC_Pattern() {
    return new OutC_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link InD_Pattern}.
   */
  public InD_Pattern createInD_Pattern() {
    return new InD_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link OutD_Pattern}.
   */
  public OutD_Pattern createOutD_Pattern() {
    return new OutD_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link InE_Pattern}.
   */
  public InE_Pattern createInE_Pattern() {
    return new InE_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link OutE_Pattern}.
   */
  public OutE_Pattern createOutE_Pattern() {
    return new OutE_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link InF_Pattern}.
   */
  public InF_Pattern createInF_Pattern() {
    return new InF_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link OutF_Pattern}.
   */
  public OutF_Pattern createOutF_Pattern() {
    return new OutF_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link InH_Pattern}.
   */
  public InH_Pattern createInH_Pattern() {
    return new InH_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link OutH_Pattern}.
   */
  public OutH_Pattern createOutH_Pattern() {
    return new OutH_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link ZEntersPlus_Pattern}.
   */
  public ZEntersPlus_Pattern createZEntersPlus_Pattern() {
    return new ZEntersPlus_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link ZEntersMinus_Pattern}.
   */
  public ZEntersMinus_Pattern createZEntersMinus_Pattern() {
    return new ZEntersMinus_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link ZLeavesPlus_Pattern}.
   */
  public ZLeavesPlus_Pattern createZLeavesPlus_Pattern() {
    return new ZLeavesPlus_Pattern();
  }
  
  /**
   * Factory method for atomic query result event pattern {@link ZLeavesMinus_Pattern}.
   */
  public ZLeavesMinus_Pattern createZLeavesMinus_Pattern() {
    return new ZLeavesMinus_Pattern();
  }
  
  /**
   * Factory method for complex event pattern {@link Squat_Pattern}.
   */
  public Squat_Pattern createSquat_Pattern() {
    return new Squat_Pattern();
  }
  
  /**
   * Factory method for complex event pattern {@link TakeOff_Pattern}.
   */
  public TakeOff_Pattern createTakeOff_Pattern() {
    return new TakeOff_Pattern();
  }
  
  /**
   * Factory method for complex event pattern {@link InAir_Pattern}.
   */
  public InAir_Pattern createInAir_Pattern() {
    return new InAir_Pattern();
  }
  
  /**
   * Factory method for complex event pattern {@link Land_Pattern}.
   */
  public Land_Pattern createLand_Pattern() {
    return new Land_Pattern();
  }
  
  /**
   * Factory method for complex event pattern {@link Jump_Pattern}.
   */
  public Jump_Pattern createJump_Pattern() {
    return new Jump_Pattern();
  }
  
  /**
   * Factory method for complex event pattern {@link UpDownEvent_Pattern}.
   */
  public UpDownEvent_Pattern createUpDownEvent_Pattern() {
    return new UpDownEvent_Pattern();
  }
  
  /**
   * Factory method for complex event pattern {@link DownUpEvent_Pattern}.
   */
  public DownUpEvent_Pattern createDownUpEvent_Pattern() {
    return new DownUpEvent_Pattern();
  }
  
  /**
   * Factory method for rule {@link SensorDidUpdateRule}.
   */
  public Class<? extends ICepRule> rule_SensorDidUpdateRule() {
    return SensorDidUpdateRule.class;
  }
  
  /**
   * Factory method for rule {@link InARule}.
   */
  public Class<? extends ICepRule> rule_InARule() {
    return InARule.class;
  }
  
  /**
   * Factory method for rule {@link OutARule}.
   */
  public Class<? extends ICepRule> rule_OutARule() {
    return OutARule.class;
  }
  
  /**
   * Factory method for rule {@link InBRule}.
   */
  public Class<? extends ICepRule> rule_InBRule() {
    return InBRule.class;
  }
  
  /**
   * Factory method for rule {@link OutBRule}.
   */
  public Class<? extends ICepRule> rule_OutBRule() {
    return OutBRule.class;
  }
  
  /**
   * Factory method for rule {@link InCRule}.
   */
  public Class<? extends ICepRule> rule_InCRule() {
    return InCRule.class;
  }
  
  /**
   * Factory method for rule {@link OutCRule}.
   */
  public Class<? extends ICepRule> rule_OutCRule() {
    return OutCRule.class;
  }
  
  /**
   * Factory method for rule {@link InDRule}.
   */
  public Class<? extends ICepRule> rule_InDRule() {
    return InDRule.class;
  }
  
  /**
   * Factory method for rule {@link OutDRule}.
   */
  public Class<? extends ICepRule> rule_OutDRule() {
    return OutDRule.class;
  }
  
  /**
   * Factory method for rule {@link InERule}.
   */
  public Class<? extends ICepRule> rule_InERule() {
    return InERule.class;
  }
  
  /**
   * Factory method for rule {@link OutERule}.
   */
  public Class<? extends ICepRule> rule_OutERule() {
    return OutERule.class;
  }
  
  /**
   * Factory method for rule {@link InFRule}.
   */
  public Class<? extends ICepRule> rule_InFRule() {
    return InFRule.class;
  }
  
  /**
   * Factory method for rule {@link OutFRule}.
   */
  public Class<? extends ICepRule> rule_OutFRule() {
    return OutFRule.class;
  }
  
  /**
   * Factory method for rule {@link InHRule}.
   */
  public Class<? extends ICepRule> rule_InHRule() {
    return InHRule.class;
  }
  
  /**
   * Factory method for rule {@link OutHRule}.
   */
  public Class<? extends ICepRule> rule_OutHRule() {
    return OutHRule.class;
  }
  
  /**
   * Factory method for rule {@link InARuleA}.
   */
  public Class<? extends ICepRule> rule_InARuleA() {
    return InARuleA.class;
  }
  
  /**
   * Factory method for rule {@link OutARuleA}.
   */
  public Class<? extends ICepRule> rule_OutARuleA() {
    return OutARuleA.class;
  }
  
  /**
   * Factory method for rule {@link InBRuleA}.
   */
  public Class<? extends ICepRule> rule_InBRuleA() {
    return InBRuleA.class;
  }
  
  /**
   * Factory method for rule {@link InCRuleA}.
   */
  public Class<? extends ICepRule> rule_InCRuleA() {
    return InCRuleA.class;
  }
  
  /**
   * Factory method for rule {@link InDRuleA}.
   */
  public Class<? extends ICepRule> rule_InDRuleA() {
    return InDRuleA.class;
  }
  
  /**
   * Factory method for rule {@link InERuleA}.
   */
  public Class<? extends ICepRule> rule_InERuleA() {
    return InERuleA.class;
  }
  
  /**
   * Factory method for rule {@link InFRuleA}.
   */
  public Class<? extends ICepRule> rule_InFRuleA() {
    return InFRuleA.class;
  }
  
  /**
   * Factory method for rule {@link InHRuleA}.
   */
  public Class<? extends ICepRule> rule_InHRuleA() {
    return InHRuleA.class;
  }
  
  /**
   * Factory method for rule {@link SquatRule}.
   */
  public Class<? extends ICepRule> rule_SquatRule() {
    return SquatRule.class;
  }
  
  /**
   * Factory method for rule {@link TakeOffRule}.
   */
  public Class<? extends ICepRule> rule_TakeOffRule() {
    return TakeOffRule.class;
  }
  
  /**
   * Factory method for rule {@link InAirRule}.
   */
  public Class<? extends ICepRule> rule_InAirRule() {
    return InAirRule.class;
  }
  
  /**
   * Factory method for rule {@link LandRule}.
   */
  public Class<? extends ICepRule> rule_LandRule() {
    return LandRule.class;
  }
  
  /**
   * Factory method for rule {@link JumpRule}.
   */
  public Class<? extends ICepRule> rule_JumpRule() {
    return JumpRule.class;
  }
  
  /**
   * Factory method for rule {@link ZPlusEnterRule}.
   */
  public Class<? extends ICepRule> rule_ZPlusEnterRule() {
    return ZPlusEnterRule.class;
  }
  
  /**
   * Factory method for rule {@link ZMinusEnterRule}.
   */
  public Class<? extends ICepRule> rule_ZMinusEnterRule() {
    return ZMinusEnterRule.class;
  }
  
  /**
   * Factory method for rule {@link ZPlusLeaveRule}.
   */
  public Class<? extends ICepRule> rule_ZPlusLeaveRule() {
    return ZPlusLeaveRule.class;
  }
  
  /**
   * Factory method for rule {@link ZMinusLeaveRule}.
   */
  public Class<? extends ICepRule> rule_ZMinusLeaveRule() {
    return ZMinusLeaveRule.class;
  }
  
  /**
   * Factory method for rule {@link UpDownRule}.
   */
  public Class<? extends ICepRule> rule_UpDownRule() {
    return UpDownRule.class;
  }
  
  /**
   * Factory method for rule {@link DownUpRule}.
   */
  public Class<? extends ICepRule> rule_DownUpRule() {
    return DownUpRule.class;
  }
  
  /**
   * Factory method for instantiating every defined rule.
   */
  public List<Class<? extends ICepRule>> allRules() {
    List<Class<? extends ICepRule>> rules = Lists.newArrayList();
    rules.add(SensorDidUpdateRule.class);
    rules.add(InARule.class);
    rules.add(OutARule.class);
    rules.add(InBRule.class);
    rules.add(OutBRule.class);
    rules.add(InCRule.class);
    rules.add(OutCRule.class);
    rules.add(InDRule.class);
    rules.add(OutDRule.class);
    rules.add(InERule.class);
    rules.add(OutERule.class);
    rules.add(InFRule.class);
    rules.add(OutFRule.class);
    rules.add(InHRule.class);
    rules.add(OutHRule.class);
    rules.add(InARuleA.class);
    rules.add(OutARuleA.class);
    rules.add(InBRuleA.class);
    rules.add(InCRuleA.class);
    rules.add(InDRuleA.class);
    rules.add(InERuleA.class);
    rules.add(InFRuleA.class);
    rules.add(InHRuleA.class);
    rules.add(SquatRule.class);
    rules.add(TakeOffRule.class);
    rules.add(InAirRule.class);
    rules.add(LandRule.class);
    rules.add(JumpRule.class);
    rules.add(ZPlusEnterRule.class);
    rules.add(ZMinusEnterRule.class);
    rules.add(ZPlusLeaveRule.class);
    rules.add(ZMinusLeaveRule.class);
    rules.add(UpDownRule.class);
    rules.add(DownUpRule.class);
    return rules;
  }
}
