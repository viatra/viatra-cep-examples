package com.rh12.tbcep.vepl.mapping;

import com.rh12.tbcep.queries.JumpAMatch;
import com.rh12.tbcep.queries.JumpAMatcher;
import com.rh12.tbcep.queries.JumpBMatch;
import com.rh12.tbcep.queries.JumpBMatcher;
import com.rh12.tbcep.queries.JumpCMatch;
import com.rh12.tbcep.queries.JumpCMatcher;
import com.rh12.tbcep.queries.JumpDMatch;
import com.rh12.tbcep.queries.JumpDMatcher;
import com.rh12.tbcep.queries.JumpEMatch;
import com.rh12.tbcep.queries.JumpEMatcher;
import com.rh12.tbcep.queries.JumpFMatch;
import com.rh12.tbcep.queries.JumpFMatcher;
import com.rh12.tbcep.queries.JumpHMatch;
import com.rh12.tbcep.queries.JumpHMatcher;
import com.rh12.tbcep.queries.SensorZMinusMatch;
import com.rh12.tbcep.queries.SensorZMinusMatcher;
import com.rh12.tbcep.queries.SensorZPlusMatch;
import com.rh12.tbcep.queries.SensorZPlusMatcher;
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
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.emf.EMFScope;
import org.eclipse.incquery.runtime.evm.specific.Lifecycles;
import org.eclipse.incquery.runtime.evm.specific.event.IncQueryActivationStateEnum;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.cep.core.streams.EventStream;
import org.eclipse.viatra.emf.runtime.rules.EventDrivenTransformationRuleGroup;
import org.eclipse.viatra.emf.runtime.rules.eventdriven.EventDrivenTransformationRule;
import org.eclipse.viatra.emf.runtime.rules.eventdriven.EventDrivenTransformationRuleFactory;
import org.eclipse.viatra.emf.runtime.transformation.eventdriven.EventDrivenTransformation;
import org.eclipse.viatra.emf.runtime.transformation.eventdriven.InconsistentEventSemanticsException;

@SuppressWarnings("all")
public class QueryEngine2ViatraCep {
  private EventStream eventStream;
  
  private ResourceSet resourceSet;
  
  private EventDrivenTransformation transformation;
  
  private QueryEngine2ViatraCep(final ResourceSet resourceSet, final EventStream eventStream) {
    this.resourceSet = resourceSet;
    this.eventStream = eventStream;
    registerRules();
  }
  
  public static QueryEngine2ViatraCep register(final ResourceSet resourceSet, final EventStream eventStream) {
    return new QueryEngine2ViatraCep(resourceSet, eventStream);
  }
  
  public EventDrivenTransformationRuleGroup getRules() {
    EventDrivenTransformationRuleGroup ruleGroup = new EventDrivenTransformationRuleGroup(
    	createjumpE_MappingRule(), 
    	createjumpA_MappingRule(), 
    	createjumpD_MappingRule(), 
    	createsensorZMinus_MappingRule(), 
    	createjumpB_MappingRule(), 
    	createjumpH_MappingRule(), 
    	createjumpC_MappingRule(), 
    	createjumpF_MappingRule(), 
    	createsensorZPlus_MappingRule()
    );
    return ruleGroup;
  }
  
  private void registerRules() {
    try {
    	transformation = EventDrivenTransformation.forScope(new EMFScope(resourceSet)).addRules(getRules()).create();
    } catch (IncQueryException e) {
    	e.printStackTrace();
    }
  }
  
  public EventDrivenTransformationRule<JumpEMatch, JumpEMatcher> createjumpE_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder<JumpEMatch, JumpEMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(JumpEMatcher.querySpecification());
      
      IMatchProcessor<JumpEMatch> actionOnAppear_0 = new IMatchProcessor<JumpEMatch>() {
        public void process(final JumpEMatch matchedPattern) {
          InE_Event event = new InE_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.APPEARED, actionOnAppear_0);
      
      IMatchProcessor<JumpEMatch> actionOnDisappear_0 = new IMatchProcessor<JumpEMatch>() {
        public void process(final JumpEMatch matchedPattern) {
          OutE_Event event = new OutE_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.DISAPPEARED, actionOnDisappear_0);
      
      return builder.build();
    } catch (IncQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public EventDrivenTransformationRule<JumpAMatch, JumpAMatcher> createjumpA_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder<JumpAMatch, JumpAMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(JumpAMatcher.querySpecification());
      
      IMatchProcessor<JumpAMatch> actionOnAppear_0 = new IMatchProcessor<JumpAMatch>() {
        public void process(final JumpAMatch matchedPattern) {
          InA_Event event = new InA_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.APPEARED, actionOnAppear_0);
      
      IMatchProcessor<JumpAMatch> actionOnDisappear_0 = new IMatchProcessor<JumpAMatch>() {
        public void process(final JumpAMatch matchedPattern) {
          OutA_Event event = new OutA_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.DISAPPEARED, actionOnDisappear_0);
      
      return builder.build();
    } catch (IncQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public EventDrivenTransformationRule<JumpDMatch, JumpDMatcher> createjumpD_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder<JumpDMatch, JumpDMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(JumpDMatcher.querySpecification());
      
      IMatchProcessor<JumpDMatch> actionOnAppear_0 = new IMatchProcessor<JumpDMatch>() {
        public void process(final JumpDMatch matchedPattern) {
          InD_Event event = new InD_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.APPEARED, actionOnAppear_0);
      
      IMatchProcessor<JumpDMatch> actionOnDisappear_0 = new IMatchProcessor<JumpDMatch>() {
        public void process(final JumpDMatch matchedPattern) {
          OutD_Event event = new OutD_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.DISAPPEARED, actionOnDisappear_0);
      
      return builder.build();
    } catch (IncQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public EventDrivenTransformationRule<SensorZMinusMatch, SensorZMinusMatcher> createsensorZMinus_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder<SensorZMinusMatch, SensorZMinusMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(SensorZMinusMatcher.querySpecification());
      
      IMatchProcessor<SensorZMinusMatch> actionOnAppear_0 = new IMatchProcessor<SensorZMinusMatch>() {
        public void process(final SensorZMinusMatch matchedPattern) {
          ZEntersMinus_Event event = new ZEntersMinus_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.APPEARED, actionOnAppear_0);
      
      IMatchProcessor<SensorZMinusMatch> actionOnDisappear_0 = new IMatchProcessor<SensorZMinusMatch>() {
        public void process(final SensorZMinusMatch matchedPattern) {
          ZLeavesMinus_Event event = new ZLeavesMinus_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.DISAPPEARED, actionOnDisappear_0);
      
      return builder.build();
    } catch (IncQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public EventDrivenTransformationRule<JumpBMatch, JumpBMatcher> createjumpB_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder<JumpBMatch, JumpBMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(JumpBMatcher.querySpecification());
      
      IMatchProcessor<JumpBMatch> actionOnAppear_0 = new IMatchProcessor<JumpBMatch>() {
        public void process(final JumpBMatch matchedPattern) {
          InB_Event event = new InB_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.APPEARED, actionOnAppear_0);
      
      IMatchProcessor<JumpBMatch> actionOnDisappear_0 = new IMatchProcessor<JumpBMatch>() {
        public void process(final JumpBMatch matchedPattern) {
          OutB_Event event = new OutB_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.DISAPPEARED, actionOnDisappear_0);
      
      return builder.build();
    } catch (IncQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public EventDrivenTransformationRule<JumpHMatch, JumpHMatcher> createjumpH_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder<JumpHMatch, JumpHMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(JumpHMatcher.querySpecification());
      
      IMatchProcessor<JumpHMatch> actionOnAppear_0 = new IMatchProcessor<JumpHMatch>() {
        public void process(final JumpHMatch matchedPattern) {
          InH_Event event = new InH_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.APPEARED, actionOnAppear_0);
      
      IMatchProcessor<JumpHMatch> actionOnDisappear_0 = new IMatchProcessor<JumpHMatch>() {
        public void process(final JumpHMatch matchedPattern) {
          OutH_Event event = new OutH_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.DISAPPEARED, actionOnDisappear_0);
      
      return builder.build();
    } catch (IncQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public EventDrivenTransformationRule<JumpCMatch, JumpCMatcher> createjumpC_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder<JumpCMatch, JumpCMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(JumpCMatcher.querySpecification());
      
      IMatchProcessor<JumpCMatch> actionOnAppear_0 = new IMatchProcessor<JumpCMatch>() {
        public void process(final JumpCMatch matchedPattern) {
          InC_Event event = new InC_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.APPEARED, actionOnAppear_0);
      
      IMatchProcessor<JumpCMatch> actionOnDisappear_0 = new IMatchProcessor<JumpCMatch>() {
        public void process(final JumpCMatch matchedPattern) {
          OutC_Event event = new OutC_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.DISAPPEARED, actionOnDisappear_0);
      
      return builder.build();
    } catch (IncQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public EventDrivenTransformationRule<JumpFMatch, JumpFMatcher> createjumpF_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder<JumpFMatch, JumpFMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(JumpFMatcher.querySpecification());
      
      IMatchProcessor<JumpFMatch> actionOnAppear_0 = new IMatchProcessor<JumpFMatch>() {
        public void process(final JumpFMatch matchedPattern) {
          InF_Event event = new InF_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.APPEARED, actionOnAppear_0);
      
      IMatchProcessor<JumpFMatch> actionOnDisappear_0 = new IMatchProcessor<JumpFMatch>() {
        public void process(final JumpFMatch matchedPattern) {
          OutF_Event event = new OutF_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.DISAPPEARED, actionOnDisappear_0);
      
      return builder.build();
    } catch (IncQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public EventDrivenTransformationRule<SensorZPlusMatch, SensorZPlusMatcher> createsensorZPlus_MappingRule() {
    try{
      EventDrivenTransformationRuleFactory.EventDrivenTransformationBuilder<SensorZPlusMatch, SensorZPlusMatcher> builder = new EventDrivenTransformationRuleFactory().createRule();
      builder.addLifeCycle(Lifecycles.getDefault(false, true));
      builder.precondition(SensorZPlusMatcher.querySpecification());
      
      IMatchProcessor<SensorZPlusMatch> actionOnAppear_0 = new IMatchProcessor<SensorZPlusMatch>() {
        public void process(final SensorZPlusMatch matchedPattern) {
          ZEntersPlus_Event event = new ZEntersPlus_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.APPEARED, actionOnAppear_0);
      
      IMatchProcessor<SensorZPlusMatch> actionOnDisappear_0 = new IMatchProcessor<SensorZPlusMatch>() {
        public void process(final SensorZPlusMatch matchedPattern) {
          ZLeavesPlus_Event event = new ZLeavesPlus_Event(null);
          event.setIncQueryPattern(matchedPattern);
          eventStream.push(event);
        }
      };
      builder.action(IncQueryActivationStateEnum.DISAPPEARED, actionOnDisappear_0);
      
      return builder.build();
    } catch (IncQueryException e) {
      e.printStackTrace();
    } catch (InconsistentEventSemanticsException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public void dispose() {
    this.transformation = null;
  }
}
