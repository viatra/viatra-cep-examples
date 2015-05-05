package bodymodel.ymca;

import bodymodel.ymca.BentRightArmMatch;
import bodymodel.ymca.util.BentRightArmQuerySpecification;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.eclipse.incquery.runtime.api.IQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseMatcher;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.tuple.Tuple;
import org.eclipse.incquery.runtime.util.IncQueryLoggingUtil;
import org.jnect.bodymodel.Body;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * Generated pattern matcher API of the bodymodel.ymca.bentRightArm pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link BentRightArmMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * Right arm is bent 90'.
 *  
 * {@literal @}QueryExplorer(display = true)
 * pattern bentRightArm(B: Body, RH: RightHand, RE:RightElbow, RS:RightShoulder) {
 * 	Body.RightHand(B, RH);
 * 	Body.RightElbow(B, RE);
 * 	Body.Head(B, H);
 * 	
 * 	// indicate coordinates to be used for check calculation
 * 	PositionedElement.x(RH,RHX);
 * 	PositionedElement.y(RH,RHY);
 * 	PositionedElement.z(RH,RHZ);
 * 	PositionedElement.x(RE,REX);
 * 	PositionedElement.y(RE,REY);
 * 	PositionedElement.z(RE,REZ);
 * 	PositionedElement.x(RS,RSX);
 * 	PositionedElement.y(RS,RSY);
 * 	PositionedElement.z(RS,RSZ);
 * 	// check that the angle between the lower arm (H-E)
 * 	// and upper arm (S-E) is around PI/2 (90')
 * 	check({
 * 		// we need to "wire" attribute values into the check expression
 * 		var float angleBetween = VectorMaths::angleBetween(
 * 			VectorMaths::createVector(
 * 				MovingAverageCalculator::getCalculator("RHX").addValue(RHX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("RHY").addValue(RHY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("RHZ").addValue(RHZ).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("REX").addValue(REX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("REY").addValue(REY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("REZ").addValue(REZ).movingAvg
 * 			),
 * 			VectorMaths::createVector(
 * 				MovingAverageCalculator::getCalculator("RSX").addValue(RSX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("RSY").addValue(RSY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("RSZ").addValue(RSZ).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("REX").addValue(REX).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("REY").addValue(REY).movingAvg, 
 * 				MovingAverageCalculator::getCalculator("REZ").addValue(REZ).movingAvg
 * 			)
 * 		)
 * 		// System::out.println(angleBetween)
 * 		Math::abs(Math::PI/2 - angleBetween) {@literal <} YMCAConstants::angleTolerance
 * 	});
 * }
 * </pre></code>
 * 
 * @see BentRightArmMatch
 * @see BentRightArmProcessor
 * @see BentRightArmQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class BentRightArmMatcher extends BaseMatcher<BentRightArmMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static BentRightArmMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    BentRightArmMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new BentRightArmMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_B = 0;
  
  private final static int POSITION_RH = 1;
  
  private final static int POSITION_RE = 2;
  
  private final static int POSITION_RS = 3;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(BentRightArmMatcher.class);
  
  /**
   * Initializes the pattern matcher over a given EMF model root (recommended: Resource or ResourceSet).
   * If a pattern matcher is already constructed with the same root, only a light-weight reference is returned.
   * The scope of pattern matching will be the given EMF model root and below (see FAQ for more precise definition).
   * The match set will be incrementally refreshed upon updates from this scope.
   * <p>The matcher will be created within the managed {@link IncQueryEngine} belonging to the EMF model root, so
   * multiple matchers will reuse the same engine and benefit from increased performance and reduced memory footprint.
   * @param emfRoot the root of the EMF containment hierarchy where the pattern matcher will operate. Recommended: Resource or ResourceSet.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead, e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}
   * 
   */
  @Deprecated
  public BentRightArmMatcher(final Notifier emfRoot) throws IncQueryException {
    this(IncQueryEngine.on(emfRoot));
  }
  
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * @deprecated use {@link #on(IncQueryEngine)} instead
   * 
   */
  @Deprecated
  public BentRightArmMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return matches represented as a BentRightArmMatch object.
   * 
   */
  public Collection<BentRightArmMatch> getAllMatches(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    return rawGetAllMatches(new Object[]{pB, pRH, pRE, pRS});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return a match represented as a BentRightArmMatch object, or null if no match is found.
   * 
   */
  public BentRightArmMatch getOneArbitraryMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    return rawGetOneArbitraryMatch(new Object[]{pB, pRH, pRE, pRS});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    return rawHasMatch(new Object[]{pB, pRH, pRE, pRS});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    return rawCountMatches(new Object[]{pB, pRH, pRE, pRS});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final IMatchProcessor<? super BentRightArmMatch> processor) {
    rawForEachMatch(new Object[]{pB, pRH, pRE, pRS}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pRE the fixed value of pattern parameter RE, or null if not bound.
   * @param pRS the fixed value of pattern parameter RS, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final IMatchProcessor<? super BentRightArmMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pB, pRH, pRE, pRS}, processor);
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
  public BentRightArmMatch newMatch(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    return BentRightArmMatch.newMatch(pB, pRH, pRE, pRS);
  }
  
  /**
   * Retrieve the set of values that occur in matches for B.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Body> rawAccumulateAllValuesOfB(final Object[] parameters) {
    Set<Body> results = new HashSet<Body>();
    rawAccumulateAllValues(POSITION_B, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for B.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Body> getAllValuesOfB() {
    return rawAccumulateAllValuesOfB(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for B.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Body> getAllValuesOfB(final BentRightArmMatch partialMatch) {
    return rawAccumulateAllValuesOfB(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for B.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Body> getAllValuesOfB(final RightHand pRH, final RightElbow pRE, final RightShoulder pRS) {
    return rawAccumulateAllValuesOfB(new Object[]{
    null, 
    pRH, 
    pRE, 
    pRS
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RightHand> rawAccumulateAllValuesOfRH(final Object[] parameters) {
    Set<RightHand> results = new HashSet<RightHand>();
    rawAccumulateAllValues(POSITION_RH, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightHand> getAllValuesOfRH() {
    return rawAccumulateAllValuesOfRH(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightHand> getAllValuesOfRH(final BentRightArmMatch partialMatch) {
    return rawAccumulateAllValuesOfRH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightHand> getAllValuesOfRH(final Body pB, final RightElbow pRE, final RightShoulder pRS) {
    return rawAccumulateAllValuesOfRH(new Object[]{
    pB, 
    null, 
    pRE, 
    pRS
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RightElbow> rawAccumulateAllValuesOfRE(final Object[] parameters) {
    Set<RightElbow> results = new HashSet<RightElbow>();
    rawAccumulateAllValues(POSITION_RE, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightElbow> getAllValuesOfRE() {
    return rawAccumulateAllValuesOfRE(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightElbow> getAllValuesOfRE(final BentRightArmMatch partialMatch) {
    return rawAccumulateAllValuesOfRE(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RE.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightElbow> getAllValuesOfRE(final Body pB, final RightHand pRH, final RightShoulder pRS) {
    return rawAccumulateAllValuesOfRE(new Object[]{
    pB, 
    pRH, 
    null, 
    pRS
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<RightShoulder> rawAccumulateAllValuesOfRS(final Object[] parameters) {
    Set<RightShoulder> results = new HashSet<RightShoulder>();
    rawAccumulateAllValues(POSITION_RS, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightShoulder> getAllValuesOfRS() {
    return rawAccumulateAllValuesOfRS(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightShoulder> getAllValuesOfRS(final BentRightArmMatch partialMatch) {
    return rawAccumulateAllValuesOfRS(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RS.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightShoulder> getAllValuesOfRS(final Body pB, final RightHand pRH, final RightElbow pRE) {
    return rawAccumulateAllValuesOfRS(new Object[]{
    pB, 
    pRH, 
    pRE, 
    null
    });
  }
  
  @Override
  protected BentRightArmMatch tupleToMatch(final Tuple t) {
    try {
    	return BentRightArmMatch.newMatch((org.jnect.bodymodel.Body) t.get(POSITION_B), (org.jnect.bodymodel.RightHand) t.get(POSITION_RH), (org.jnect.bodymodel.RightElbow) t.get(POSITION_RE), (org.jnect.bodymodel.RightShoulder) t.get(POSITION_RS));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected BentRightArmMatch arrayToMatch(final Object[] match) {
    try {
    	return BentRightArmMatch.newMatch((org.jnect.bodymodel.Body) match[POSITION_B], (org.jnect.bodymodel.RightHand) match[POSITION_RH], (org.jnect.bodymodel.RightElbow) match[POSITION_RE], (org.jnect.bodymodel.RightShoulder) match[POSITION_RS]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected BentRightArmMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return BentRightArmMatch.newMutableMatch((org.jnect.bodymodel.Body) match[POSITION_B], (org.jnect.bodymodel.RightHand) match[POSITION_RH], (org.jnect.bodymodel.RightElbow) match[POSITION_RE], (org.jnect.bodymodel.RightShoulder) match[POSITION_RS]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  /**
   * @return the singleton instance of the query specification of this pattern
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static IQuerySpecification<BentRightArmMatcher> querySpecification() throws IncQueryException {
    return BentRightArmQuerySpecification.instance();
  }
}
