package com.rh12.tbcep.queries;

import com.rh12.tbcep.queries.util.JumpEQuerySpecification;
import java.util.Arrays;
import java.util.List;
import model.Sensor;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * Pattern-specific match representation of the com.rh12.tbcep.queries.jumpE pattern,
 * to be used in conjunction with {@link JumpEMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see JumpEMatcher
 * @see JumpEProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class JumpEMatch extends BasePatternMatch {
  private Sensor fSensor;
  
  private static List<String> parameterNames = makeImmutableList("sensor");
  
  private JumpEMatch(final Sensor pSensor) {
    this.fSensor = pSensor;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("sensor".equals(parameterName)) return this.fSensor;
    return null;
  }
  
  public Sensor getSensor() {
    return this.fSensor;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("sensor".equals(parameterName) ) {
    	this.fSensor = (model.Sensor) newValue;
    	return true;
    }
    return false;
  }
  
  public void setSensor(final Sensor pSensor) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fSensor = pSensor;
  }
  
  @Override
  public String patternName() {
    return "com.rh12.tbcep.queries.jumpE";
  }
  
  @Override
  public List<String> parameterNames() {
    return JumpEMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fSensor};
  }
  
  @Override
  public JumpEMatch toImmutable() {
    return isMutable() ? newMatch(fSensor) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"sensor\"=" + prettyPrintValue(fSensor)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fSensor == null) ? 0 : fSensor.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof JumpEMatch)) { // this should be infrequent
    	if (obj == null) {
    		return false;
    	}
    	if (!(obj instanceof IPatternMatch)) {
    		return false;
    	}
    	IPatternMatch otherSig  = (IPatternMatch) obj;
    	if (!specification().equals(otherSig.specification()))
    		return false;
    	return Arrays.deepEquals(toArray(), otherSig.toArray());
    }
    JumpEMatch other = (JumpEMatch) obj;
    if (fSensor == null) {if (other.fSensor != null) return false;}
    else if (!fSensor.equals(other.fSensor)) return false;
    return true;
  }
  
  @Override
  public JumpEQuerySpecification specification() {
    try {
    	return JumpEQuerySpecification.instance();
    } catch (IncQueryException ex) {
     	// This cannot happen, as the match object can only be instantiated if the query specification exists
     	throw new IllegalStateException (ex);
    }
  }
  
  /**
   * Returns an empty, mutable match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @return the empty match.
   * 
   */
  public static JumpEMatch newEmptyMatch() {
    return new Mutable(null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pSensor the fixed value of pattern parameter sensor, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static JumpEMatch newMutableMatch(final Sensor pSensor) {
    return new Mutable(pSensor);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pSensor the fixed value of pattern parameter sensor, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static JumpEMatch newMatch(final Sensor pSensor) {
    return new Immutable(pSensor);
  }
  
  private static final class Mutable extends JumpEMatch {
    Mutable(final Sensor pSensor) {
      super(pSensor);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends JumpEMatch {
    Immutable(final Sensor pSensor) {
      super(pSensor);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
