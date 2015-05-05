package org.eclipse.viatra.cep.examples.sosym.eventmodel;

import com.google.common.collect.Lists;
import java.util.List;
import org.eclipse.viatra.cep.core.api.rules.ICepRule;
import org.eclipse.viatra.cep.core.metamodels.events.EventSource;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.events.InvalidModel_Event;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.events.ValidModel_Event;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.atomic.InvalidModel_Pattern;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.atomic.ValidModel_Pattern;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.patterns.complex.TolerationRange_Pattern;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.rules.InvalidModelEventObserved;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.rules.ToleranceLimitReached;
import org.eclipse.viatra.cep.examples.sosym.eventmodel.rules.ValidModelEventObserved;

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
   * Factory method for event class {@link InvalidModel_Event}.
   */
  public InvalidModel_Event createInvalidModel_Event(final EventSource eventSource) {
    return new InvalidModel_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link InvalidModel_Event}.
   */
  public InvalidModel_Event createInvalidModel_Event() {
    return new InvalidModel_Event(null);
  }
  
  /**
   * Factory method for event class {@link ValidModel_Event}.
   */
  public ValidModel_Event createValidModel_Event(final EventSource eventSource) {
    return new ValidModel_Event(eventSource);
  }
  
  /**
   * Factory method for event class {@link ValidModel_Event}.
   */
  public ValidModel_Event createValidModel_Event() {
    return new ValidModel_Event(null);
  }
  
  /**
   * Factory method for atomic event pattern {@link InvalidModel_Pattern}.
   */
  public InvalidModel_Pattern createInvalidModel_Pattern() {
    return new InvalidModel_Pattern();
  }
  
  /**
   * Factory method for atomic event pattern {@link ValidModel_Pattern}.
   */
  public ValidModel_Pattern createValidModel_Pattern() {
    return new ValidModel_Pattern();
  }
  
  /**
   * Factory method for complex event pattern {@link TolerationRange_Pattern}.
   */
  public TolerationRange_Pattern createTolerationRange_Pattern() {
    return new TolerationRange_Pattern();
  }
  
  /**
   * Factory method for rule {@link InvalidModelEventObserved}.
   */
  public InvalidModelEventObserved createInvalidModelEventObserved() {
    return new InvalidModelEventObserved();
  }
  
  /**
   * Factory method for rule {@link ValidModelEventObserved}.
   */
  public ValidModelEventObserved createValidModelEventObserved() {
    return new ValidModelEventObserved();
  }
  
  /**
   * Factory method for rule {@link ToleranceLimitReached}.
   */
  public ToleranceLimitReached createToleranceLimitReached() {
    return new ToleranceLimitReached();
  }
  
  /**
   * Factory method for instantiating every defined rule.
   */
  public List<ICepRule> allRules() {
    List<ICepRule> rules = Lists.newArrayList();
    rules.add(new InvalidModelEventObserved());
    rules.add(new ValidModelEventObserved());
    rules.add(new ToleranceLimitReached());
    return rules;
  }
}
