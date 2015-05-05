package bodymodel.ymca;

import bodymodel.ymca.util.RightHandAboveHeadQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.Body;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.RightHand;

/**
 * Pattern-specific match representation of the bodymodel.ymca.rightHandAboveHead pattern,
 * to be used in conjunction with {@link RightHandAboveHeadMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see RightHandAboveHeadMatcher
 * @see RightHandAboveHeadProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class RightHandAboveHeadMatch extends BasePatternMatch {
  private Body fB;
  
  private RightHand fRH;
  
  private Head fH;
  
  private static List<String> parameterNames = makeImmutableList("B", "RH", "H");
  
  private RightHandAboveHeadMatch(final Body pB, final RightHand pRH, final Head pH) {
    this.fB = pB;
    this.fRH = pRH;
    this.fH = pH;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("B".equals(parameterName)) return this.fB;
    if ("RH".equals(parameterName)) return this.fRH;
    if ("H".equals(parameterName)) return this.fH;
    return null;
  }
  
  public Body getB() {
    return this.fB;
  }
  
  public RightHand getRH() {
    return this.fRH;
  }
  
  public Head getH() {
    return this.fH;
  }
  
  @Override
  public boolean set(final String parameterName, final Object newValue) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    if ("B".equals(parameterName) ) {
    	this.fB = (org.jnect.bodymodel.Body) newValue;
    	return true;
    }
    if ("RH".equals(parameterName) ) {
    	this.fRH = (org.jnect.bodymodel.RightHand) newValue;
    	return true;
    }
    if ("H".equals(parameterName) ) {
    	this.fH = (org.jnect.bodymodel.Head) newValue;
    	return true;
    }
    return false;
  }
  
  public void setB(final Body pB) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fB = pB;
  }
  
  public void setRH(final RightHand pRH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRH = pRH;
  }
  
  public void setH(final Head pH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fH = pH;
  }
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.rightHandAboveHead";
  }
  
  @Override
  public List<String> parameterNames() {
    return RightHandAboveHeadMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fB, fRH, fH};
  }
  
  @Override
  public RightHandAboveHeadMatch toImmutable() {
    return isMutable() ? newMatch(fB, fRH, fH) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"B\"=" + prettyPrintValue(fB) + ", ");
    
    result.append("\"RH\"=" + prettyPrintValue(fRH) + ", ");
    
    result.append("\"H\"=" + prettyPrintValue(fH)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fB == null) ? 0 : fB.hashCode());
    result = prime * result + ((fRH == null) ? 0 : fRH.hashCode());
    result = prime * result + ((fH == null) ? 0 : fH.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof RightHandAboveHeadMatch)) { // this should be infrequent
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
    RightHandAboveHeadMatch other = (RightHandAboveHeadMatch) obj;
    if (fB == null) {if (other.fB != null) return false;}
    else if (!fB.equals(other.fB)) return false;
    if (fRH == null) {if (other.fRH != null) return false;}
    else if (!fRH.equals(other.fRH)) return false;
    if (fH == null) {if (other.fH != null) return false;}
    else if (!fH.equals(other.fH)) return false;
    return true;
  }
  
  @Override
  public RightHandAboveHeadQuerySpecification specification() {
    try {
    	return RightHandAboveHeadQuerySpecification.instance();
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
  public static RightHandAboveHeadMatch newEmptyMatch() {
    return new Mutable(null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static RightHandAboveHeadMatch newMutableMatch(final Body pB, final RightHand pRH, final Head pH) {
    return new Mutable(pB, pRH, pH);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static RightHandAboveHeadMatch newMatch(final Body pB, final RightHand pRH, final Head pH) {
    return new Immutable(pB, pRH, pH);
  }
  
  private static final class Mutable extends RightHandAboveHeadMatch {
    Mutable(final Body pB, final RightHand pRH, final Head pH) {
      super(pB, pRH, pH);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends RightHandAboveHeadMatch {
    Immutable(final Body pB, final RightHand pRH, final Head pH) {
      super(pB, pRH, pH);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
