package bodymodel.ymca;

import bodymodel.ymca.util.FSQuerySpecification;
import java.util.Arrays;
import java.util.List;
import org.eclipse.incquery.runtime.api.IPatternMatch;
import org.eclipse.incquery.runtime.api.impl.BasePatternMatch;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.jnect.bodymodel.Body;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * Pattern-specific match representation of the bodymodel.ymca.FS pattern,
 * to be used in conjunction with {@link FSMatcher}.
 * 
 * <p>Class fields correspond to parameters of the pattern. Fields with value null are considered unassigned.
 * Each instance is a (possibly partial) substitution of pattern parameters,
 * usable to represent a match of the pattern in the result of a query,
 * or to specify the bound (fixed) input parameters when issuing a query.
 * 
 * @see FSMatcher
 * @see FSProcessor
 * 
 */
@SuppressWarnings("all")
public abstract class FSMatch extends BasePatternMatch {
  private Body fB;
  
  private RightHand fRH;
  
  private RightElbow fRE;
  
  private RightShoulder fRS;
  
  private Head fH;
  
  private static List<String> parameterNames = makeImmutableList("B", "RH", "RE", "RS", "H");
  
  private FSMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    this.fB = pB;
    this.fRH = pRH;
    this.fRE = pRE;
    this.fRS = pRS;
    this.fH = pH;
  }
  
  @Override
  public Object get(final String parameterName) {
    if ("B".equals(parameterName)) return this.fB;
    if ("RH".equals(parameterName)) return this.fRH;
    if ("RE".equals(parameterName)) return this.fRE;
    if ("RS".equals(parameterName)) return this.fRS;
    if ("H".equals(parameterName)) return this.fH;
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
    if ("RE".equals(parameterName) ) {
    	this.fRE = (org.jnect.bodymodel.RightElbow) newValue;
    	return true;
    }
    if ("RS".equals(parameterName) ) {
    	this.fRS = (org.jnect.bodymodel.RightShoulder) newValue;
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
  
  public void setRE(final RightElbow pRE) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRE = pRE;
  }
  
  public void setRS(final RightShoulder pRS) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fRS = pRS;
  }
  
  public void setH(final Head pH) {
    if (!isMutable()) throw new java.lang.UnsupportedOperationException();
    this.fH = pH;
  }
  
  @Override
  public String patternName() {
    return "bodymodel.ymca.FS";
  }
  
  @Override
  public List<String> parameterNames() {
    return FSMatch.parameterNames;
  }
  
  @Override
  public Object[] toArray() {
    return new Object[]{fB, fRH, fRE, fRS, fH};
  }
  
  @Override
  public FSMatch toImmutable() {
    return isMutable() ? newMatch(fB, fRH, fRE, fRS, fH) : this;
  }
  
  @Override
  public String prettyPrint() {
    StringBuilder result = new StringBuilder();
    result.append("\"B\"=" + prettyPrintValue(fB) + ", ");
    
    result.append("\"RH\"=" + prettyPrintValue(fRH) + ", ");
    
    result.append("\"RE\"=" + prettyPrintValue(fRE) + ", ");
    
    result.append("\"RS\"=" + prettyPrintValue(fRS) + ", ");
    
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
    result = prime * result + ((fRE == null) ? 0 : fRE.hashCode());
    result = prime * result + ((fRS == null) ? 0 : fRS.hashCode());
    result = prime * result + ((fH == null) ? 0 : fH.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (this == obj)
    	return true;
    if (!(obj instanceof FSMatch)) { // this should be infrequent
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
    FSMatch other = (FSMatch) obj;
    if (fB == null) {if (other.fB != null) return false;}
    else if (!fB.equals(other.fB)) return false;
    if (fRH == null) {if (other.fRH != null) return false;}
    else if (!fRH.equals(other.fRH)) return false;
    if (fRE == null) {if (other.fRE != null) return false;}
    else if (!fRE.equals(other.fRE)) return false;
    if (fRS == null) {if (other.fRS != null) return false;}
    else if (!fRS.equals(other.fRS)) return false;
    if (fH == null) {if (other.fH != null) return false;}
    else if (!fH.equals(other.fH)) return false;
    return true;
  }
  
  @Override
  public FSQuerySpecification specification() {
    try {
    	return FSQuerySpecification.instance();
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
  public static FSMatch newEmptyMatch() {
    return new Mutable(null, null, null, null, null);
  }
  
  /**
   * Returns a mutable (partial) match.
   * Fields of the mutable match can be filled to create a partial match, usable as matcher input.
   * 
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the new, mutable (partial) match object.
   * 
   */
  public static FSMatch newMutableMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    return new Mutable(pB, pRH, pRE, pRS, pH);
  }
  
  /**
   * Returns a new (partial) match.
   * This can be used e.g. to call the matcher with a partial match.
   * <p>The returned match will be immutable. Use {@link #newEmptyMatch()} to obtain a mutable match object.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the (partial) match object.
   * 
   */
  public static FSMatch newMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
    return new Immutable(pB, pRH, pRE, pRS, pH);
  }
  
  private static final class Mutable extends FSMatch {
    Mutable(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
      super(pB, pRH, pRE, pRS, pH);
    }
    
    @Override
    public boolean isMutable() {
      return true;
    }
  }
  
  private static final class Immutable extends FSMatch {
    Immutable(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH) {
      super(pB, pRH, pRE, pRS, pH);
    }
    
    @Override
    public boolean isMutable() {
      return false;
    }
  }
}
