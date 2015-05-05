package bodymodel.ymca;

import bodymodel.ymca.RightHandAboveHeadMatch;
import bodymodel.ymca.util.RightHandAboveHeadQuerySpecification;
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
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.RightHand;

/**
 * Generated pattern matcher API of the bodymodel.ymca.rightHandAboveHead pattern,
 * providing pattern-specific query methods.
 * 
 * <p>Use the pattern matcher on a given model via {@link #on(IncQueryEngine)},
 * e.g. in conjunction with {@link IncQueryEngine#on(Notifier)}.
 * 
 * <p>Matches of the pattern will be represented as {@link RightHandAboveHeadMatch}.
 * 
 * <p>Original source:
 * <code><pre>
 * This pattern is buggy! Depending on the relative position of (0,0,0) this may yield wrong results.
 *  
 * {@literal @}QueryExplorer(display = true)
 * pattern rightHandAboveHead(B: Body, RH: RightHand, H: Head) {
 * 	Body.RightHand(B, RH);
 * 	Body.Head(B, H);
 * 	
 * 	RightHand.y(RH,RHy);
 * 	Head.y(H,Hy);
 * 	
 * 	check(
 * 		MovingAverageCalculator::getCalculator("HY").addValue(Hy).movingAvg {@literal <} 
 * 		 MovingAverageCalculator::getCalculator("RHY").addValue(RHy).movingAvg
 * 	);
 * }
 * </pre></code>
 * 
 * @see RightHandAboveHeadMatch
 * @see RightHandAboveHeadProcessor
 * @see RightHandAboveHeadQuerySpecification
 * 
 */
@SuppressWarnings("all")
public class RightHandAboveHeadMatcher extends BaseMatcher<RightHandAboveHeadMatch> {
  /**
   * Initializes the pattern matcher within an existing EMF-IncQuery engine.
   * If the pattern matcher is already constructed in the engine, only a light-weight reference is returned.
   * The match set will be incrementally refreshed upon updates.
   * @param engine the existing EMF-IncQuery engine in which this matcher will be created.
   * @throws IncQueryException if an error occurs during pattern matcher creation
   * 
   */
  public static RightHandAboveHeadMatcher on(final IncQueryEngine engine) throws IncQueryException {
    // check if matcher already exists
    RightHandAboveHeadMatcher matcher = engine.getExistingMatcher(querySpecification());
    if (matcher == null) {
    	matcher = new RightHandAboveHeadMatcher(engine);
    	// do not have to "put" it into engine.matchers, reportMatcherInitialized() will take care of it
    }
    return matcher;
  }
  
  private final static int POSITION_B = 0;
  
  private final static int POSITION_RH = 1;
  
  private final static int POSITION_H = 2;
  
  private final static Logger LOGGER = IncQueryLoggingUtil.getLogger(RightHandAboveHeadMatcher.class);
  
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
  public RightHandAboveHeadMatcher(final Notifier emfRoot) throws IncQueryException {
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
  public RightHandAboveHeadMatcher(final IncQueryEngine engine) throws IncQueryException {
    super(engine, querySpecification());
  }
  
  /**
   * Returns the set of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return matches represented as a RightHandAboveHeadMatch object.
   * 
   */
  public Collection<RightHandAboveHeadMatch> getAllMatches(final Body pB, final RightHand pRH, final Head pH) {
    return rawGetAllMatches(new Object[]{pB, pRH, pH});
  }
  
  /**
   * Returns an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return a match represented as a RightHandAboveHeadMatch object, or null if no match is found.
   * 
   */
  public RightHandAboveHeadMatch getOneArbitraryMatch(final Body pB, final RightHand pRH, final Head pH) {
    return rawGetOneArbitraryMatch(new Object[]{pB, pRH, pH});
  }
  
  /**
   * Indicates whether the given combination of specified pattern parameters constitute a valid pattern match,
   * under any possible substitution of the unspecified parameters (if any).
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return true if the input is a valid (partial) match of the pattern.
   * 
   */
  public boolean hasMatch(final Body pB, final RightHand pRH, final Head pH) {
    return rawHasMatch(new Object[]{pB, pRH, pH});
  }
  
  /**
   * Returns the number of all matches of the pattern that conform to the given fixed values of some parameters.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @return the number of pattern matches found.
   * 
   */
  public int countMatches(final Body pB, final RightHand pRH, final Head pH) {
    return rawCountMatches(new Object[]{pB, pRH, pH});
  }
  
  /**
   * Executes the given processor on each match of the pattern that conforms to the given fixed values of some parameters.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @param processor the action that will process each pattern match.
   * 
   */
  public void forEachMatch(final Body pB, final RightHand pRH, final Head pH, final IMatchProcessor<? super RightHandAboveHeadMatch> processor) {
    rawForEachMatch(new Object[]{pB, pRH, pH}, processor);
  }
  
  /**
   * Executes the given processor on an arbitrarily chosen match of the pattern that conforms to the given fixed values of some parameters.
   * Neither determinism nor randomness of selection is guaranteed.
   * @param pB the fixed value of pattern parameter B, or null if not bound.
   * @param pRH the fixed value of pattern parameter RH, or null if not bound.
   * @param pH the fixed value of pattern parameter H, or null if not bound.
   * @param processor the action that will process the selected match.
   * @return true if the pattern has at least one match with the given parameter values, false if the processor was not invoked
   * 
   */
  public boolean forOneArbitraryMatch(final Body pB, final RightHand pRH, final Head pH, final IMatchProcessor<? super RightHandAboveHeadMatch> processor) {
    return rawForOneArbitraryMatch(new Object[]{pB, pRH, pH}, processor);
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
  public RightHandAboveHeadMatch newMatch(final Body pB, final RightHand pRH, final Head pH) {
    return RightHandAboveHeadMatch.newMatch(pB, pRH, pH);
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
  public Set<Body> getAllValuesOfB(final RightHandAboveHeadMatch partialMatch) {
    return rawAccumulateAllValuesOfB(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for B.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Body> getAllValuesOfB(final RightHand pRH, final Head pH) {
    return rawAccumulateAllValuesOfB(new Object[]{
    null, 
    pRH, 
    pH
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
  public Set<RightHand> getAllValuesOfRH(final RightHandAboveHeadMatch partialMatch) {
    return rawAccumulateAllValuesOfRH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for RH.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<RightHand> getAllValuesOfRH(final Body pB, final Head pH) {
    return rawAccumulateAllValuesOfRH(new Object[]{
    pB, 
    null, 
    pH
    });
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  protected Set<Head> rawAccumulateAllValuesOfH(final Object[] parameters) {
    Set<Head> results = new HashSet<Head>();
    rawAccumulateAllValues(POSITION_H, parameters, results);
    return results;
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Head> getAllValuesOfH() {
    return rawAccumulateAllValuesOfH(emptyArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Head> getAllValuesOfH(final RightHandAboveHeadMatch partialMatch) {
    return rawAccumulateAllValuesOfH(partialMatch.toArray());
  }
  
  /**
   * Retrieve the set of values that occur in matches for H.
   * @return the Set of all values, null if no parameter with the given name exists, empty set if there are no matches
   * 
   */
  public Set<Head> getAllValuesOfH(final Body pB, final RightHand pRH) {
    return rawAccumulateAllValuesOfH(new Object[]{
    pB, 
    pRH, 
    null
    });
  }
  
  @Override
  protected RightHandAboveHeadMatch tupleToMatch(final Tuple t) {
    try {
    	return RightHandAboveHeadMatch.newMatch((org.jnect.bodymodel.Body) t.get(POSITION_B), (org.jnect.bodymodel.RightHand) t.get(POSITION_RH), (org.jnect.bodymodel.Head) t.get(POSITION_H));
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in tuple not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RightHandAboveHeadMatch arrayToMatch(final Object[] match) {
    try {
    	return RightHandAboveHeadMatch.newMatch((org.jnect.bodymodel.Body) match[POSITION_B], (org.jnect.bodymodel.RightHand) match[POSITION_RH], (org.jnect.bodymodel.Head) match[POSITION_H]);
    } catch(ClassCastException e) {
    	LOGGER.error("Element(s) in array not properly typed!",e);
    	return null;
    }
  }
  
  @Override
  protected RightHandAboveHeadMatch arrayToMatchMutable(final Object[] match) {
    try {
    	return RightHandAboveHeadMatch.newMutableMatch((org.jnect.bodymodel.Body) match[POSITION_B], (org.jnect.bodymodel.RightHand) match[POSITION_RH], (org.jnect.bodymodel.Head) match[POSITION_H]);
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
  public static IQuerySpecification<RightHandAboveHeadMatcher> querySpecification() throws IncQueryException {
    return RightHandAboveHeadQuerySpecification.instance();
  }
}
