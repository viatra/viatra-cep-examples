package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.RightHandAboveHeadMatch;
import bodymodel.ymca.RightHandAboveHeadMatcher;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.annotations.PAnnotation;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;

/**
 * A pattern-specific query specification that can instantiate RightHandAboveHeadMatcher in a type-safe way.
 * 
 * @see RightHandAboveHeadMatcher
 * @see RightHandAboveHeadMatch
 * 
 */
@SuppressWarnings("all")
public final class RightHandAboveHeadQuerySpecification extends BaseGeneratedEMFQuerySpecification<RightHandAboveHeadMatcher> {
  private RightHandAboveHeadQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static RightHandAboveHeadQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected RightHandAboveHeadMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return RightHandAboveHeadMatcher.on(engine);
  }
  
  @Override
  public RightHandAboveHeadMatch newEmptyMatch() {
    return RightHandAboveHeadMatch.newEmptyMatch();
  }
  
  @Override
  public RightHandAboveHeadMatch newMatch(final Object... parameters) {
    return RightHandAboveHeadMatch.newMatch((org.jnect.bodymodel.Body) parameters[0], (org.jnect.bodymodel.RightHand) parameters[1], (org.jnect.bodymodel.Head) parameters[2]);
  }
  
  private static class LazyHolder {
    private final static RightHandAboveHeadQuerySpecification INSTANCE = make();
    
    public static RightHandAboveHeadQuerySpecification make() {
      return new RightHandAboveHeadQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static RightHandAboveHeadQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "bodymodel.ymca.rightHandAboveHead";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("B","RH","H");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("B", "org.jnect.bodymodel.Body"),new PParameter("RH", "org.jnect.bodymodel.RightHand"),new PParameter("H", "org.jnect.bodymodel.Head"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_B = body.getOrCreateVariableByName("B");
      	PVariable var_RH = body.getOrCreateVariableByName("RH");
      	PVariable var_H = body.getOrCreateVariableByName("H");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var_RHy = body.getOrCreateVariableByName("RHy");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var_Hy = body.getOrCreateVariableByName("Hy");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_B, "B"),
      				
      		new ExportedParameter(body, var_RH, "RH"),
      				
      		new ExportedParameter(body, var_H, "H")
      	));
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeUnary(body, var_RH, getClassifierLiteral("http://org/jnect/bodymodel", "RightHand"), "http://org/jnect/bodymodel/RightHand");
      	new TypeUnary(body, var_H, getClassifierLiteral("http://org/jnect/bodymodel", "Head"), "http://org/jnect/bodymodel/Head");
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeBinary(body, CONTEXT, var_B, var__virtual_0_, getFeatureLiteral("http://org/jnect/bodymodel", "Body", "RightHand"), "http://org/jnect/bodymodel/Body.RightHand");
      	new Equality(body, var__virtual_0_, var_RH);
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeBinary(body, CONTEXT, var_B, var__virtual_1_, getFeatureLiteral("http://org/jnect/bodymodel", "Body", "Head"), "http://org/jnect/bodymodel/Body.Head");
      	new Equality(body, var__virtual_1_, var_H);
      	new TypeUnary(body, var_RH, getClassifierLiteral("http://org/jnect/bodymodel", "RightHand"), "http://org/jnect/bodymodel/RightHand");
      	new TypeBinary(body, CONTEXT, var_RH, var__virtual_2_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "y"), "http://org/jnect/bodymodel/PositionedElement.y");
      	new Equality(body, var__virtual_2_, var_RHy);
      	new TypeUnary(body, var_H, getClassifierLiteral("http://org/jnect/bodymodel", "Head"), "http://org/jnect/bodymodel/Head");
      	new TypeBinary(body, CONTEXT, var_H, var__virtual_3_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "y"), "http://org/jnect/bodymodel/PositionedElement.y");
      	new Equality(body, var__virtual_3_, var_Hy);
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern rightHandAboveHead";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("Hy", "RHy");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.Float Hy = (java.lang.Float) provider.getValue("Hy");
      			java.lang.Float RHy = (java.lang.Float) provider.getValue("RHy");
      			return evaluateExpression_1_1(Hy, RHy);
      		}
      
      },  null); 
      	bodies.add(body);
      }
      	{
      	PAnnotation annotation = new PAnnotation("QueryExplorer");
      	annotation.addAttribute("display", true);
      	addAnnotation(annotation);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
  
  private static boolean evaluateExpression_1_1(final Float Hy, final Float RHy) {
    MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("HY");
    MovingAverageCalculator _addValue = _calculator.addValue((Hy).floatValue());
    float _movingAvg = _addValue.getMovingAvg();
    MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("RHY");
    MovingAverageCalculator _addValue_1 = _calculator_1.addValue((RHy).floatValue());
    float _movingAvg_1 = _addValue_1.getMovingAvg();
    boolean _lessThan = (_movingAvg < _movingAvg_1);
    return _lessThan;
  }
}
