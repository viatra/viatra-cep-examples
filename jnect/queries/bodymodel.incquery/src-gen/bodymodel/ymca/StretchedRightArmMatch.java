package bodymodel.ymca;

import bodymodel.ymca.util.StretchedRightArmQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.Body;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * Pattern-specific match representation of the bodymodel.ymca.stretchedRightArm pattern,
 * to be used in conjunction with {@link StretchedRightArmMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see StretchedRightArmMatcher
 * @see StretchedRightArmProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class StretchedRightArmMatch extends BasePatternMatch {
  private Body fB;
  
  private RightHand fRH;
  
  private RightElbow fRE;
  
  private RightShoulder fRS;
  
  private static List<String> parameterNames = makeImmutableList("B", "RH", "RE", "RS");
  
  private StretchedRightArmMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    this.fB = pB;
    this.fRH = pRH;
    this.fRE = pRE;
    this.fRS = pRS;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("B".equals(parameterName)) return this.fB;
    if ("RH".equals(parameterName)) return this.fRH;
    if ("RE".equals(parameterName)) return this.fRE;
    if ("RS".equals(parameterName)) return this.fRS;
    return null;
  }
  
  public Body getB() {
    return this.fB;
  }
  
  public RightHand getRH() {
    return this.fRH;
  }
  
  public RightElbow getRE() {
    return this.fRE;
  }
  
  public RightShoulder getRS() {
    return this.fRS;
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
    if ("RE".equals(parameterName) ) {
    	this.fRE = (org.jnect.bodymodel.RightElbow) newValue;
    	return true;
    }
    if ("RS".equals(parameterName) ) {
    	this.fRS = (org.jnect.bodymodel.RightShoulder) newValue;
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
  
  public void setRE(final RightElbow pRE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRE = pRE;
  }
  
  public void setRS(final RightShoulder pRS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRS = pRS;
  }
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.stretchedRightArm";
  }
  
  @Override
  public List<String> parameterNames() {
    return StretchedRightArmMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fB, fRH, fRE, fRS};
  }
  
  @Override
  public StretchedRightArmMatch toImmutable() {
    return isMutable() ? newMatch(fB, fRH, fRE, fRS) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"B\"=" + prettyPrintValue(fB) + ", ");
    
    result.append("\"RH\"=" + prettyPrintValue(fRH) + ", ");
    
    result.append("\"RE\"=" + prettyPrintValue(fRE) + ", ");
    
    result.append("\"RS\"=" + prettyPrintValue(fRS)
    );
    return result.toString();
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((fB == null) ? 0 : fB.hashCode());
    result = prime * result + ((fRH == null) ? 0 : fRH.hashCode());
    result = prime * result + ((fRE == null) ? 0 : fRE.hashCode());
    result = prime * result + ((fRS == null) ? 0 : fRS.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof StretchedRightArmMatch)) { // this should be infrequent
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
    StretchedRightArmMatch other = (StretchedRightArmMatch) obj;
    if (fB == null) {if (other.fB != null) return false;}
    else if (!fB.equals(other.fB)) return false;
    if (fRH == null) {if (other.fRH != null) return false;}
    else if (!fRH.equals(other.fRH)) return false;
    if (fRE == null) {if (other.fRE != null) return false;}
    else if (!fRE.equals(other.fRE)) return false;
    if (fRS == null) {if (other.fRS != null) return false;}
    else if (!fRS.equals(other.fRS)) return false;
    return true;
  }
  
  @Override
  public StretchedRightArmQuerySpecification specification() {
    try {
    	return StretchedRightArmQuerySpecification.instance();
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
  public static StretchedRightArmMatch newEmptyMatch() {
    return new Mutable(null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static StretchedRightArmMatch newMutableMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    return new Mutable(pB, pRH, pRE, pRS);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static StretchedRightArmMatch newMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    return new Immutable(pB, pRH, pRE, pRS);
  }
  
  private static final class Mutable extends StretchedRightArmMatch {
    Mutable(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
      super(pB, pRH, pRE, pRS);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends StretchedRightArmMatch {
    Immutable(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
      super(pB, pRH, pRE, pRS);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
