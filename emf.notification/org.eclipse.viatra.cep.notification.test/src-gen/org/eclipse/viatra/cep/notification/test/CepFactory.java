package org.eclipse.viatra.cep.notification.test;

import com.google.common.collect.Lists;
import java.util.List;
import org.eclipse.viatra.cep.core.api.rules.ICepRule;
import org.eclipse.viatra.cep.notification.test.patterns.complex.SetTwice_Pattern;
import org.eclipse.viatra.cep.notification.test.rules.R;

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
   * Factory method for complex event pattern {@link SetTwice_Pattern}.
   */
  public SetTwice_Pattern createSetTwice_Pattern() {
    return new SetTwice_Pattern();
  }
  
  /**
   * Factory method for rule {@link R}.
   */
  public R createR() {
    return new R();
  }
  
  /**
   * Factory method for instantiating every defined rule.
   */
  public List<ICepRule> allRules() {
    List<ICepRule> rules = Lists.newArrayList();
    rules.add(new R());
    return rules;
  }
}
