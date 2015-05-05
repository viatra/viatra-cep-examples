package bodymodel.ymca.util;

import bodymodel.MovingAverageCalculator;
import bodymodel.ymca.StretchedRightArmMatch;
import bodymodel.ymca.StretchedRightArmMatcher;
import bodymodel.ymca.VectorMaths;
import bodymodel.ymca.YMCAConstants;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Vector;
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
 * A pattern-specific query specification that can instantiate StretchedRightArmMatcher in a type-safe way.
 * 
 * @see StretchedRightArmMatcher
 * @see StretchedRightArmMatch
 * 
 */
@SuppressWarnings("all")
public final class StretchedRightArmQuerySpecification extends BaseGeneratedEMFQuerySpecification<StretchedRightArmMatcher> {
  private StretchedRightArmQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static StretchedRightArmQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected StretchedRightArmMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return StretchedRightArmMatcher.on(engine);
  }
  
  @Override
  public StretchedRightArmMatch newEmptyMatch() {
    return StretchedRightArmMatch.newEmptyMatch();
  }
  
  @Override
  public StretchedRightArmMatch newMatch(final Object... parameters) {
    return StretchedRightArmMatch.newMatch((org.jnect.bodymodel.Body) parameters[0], (org.jnect.bodymodel.RightHand) parameters[1], (org.jnect.bodymodel.RightElbow) parameters[2], (org.jnect.bodymodel.RightShoulder) parameters[3]);
  }
  
  private static class LazyHolder {
    private final static StretchedRightArmQuerySpecification INSTANCE = make();
    
    public static StretchedRightArmQuerySpecification make() {
      return new StretchedRightArmQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static StretchedRightArmQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "bodymodel.ymca.stretchedRightArm";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("B","RH","RE","RS");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("B", "org.jnect.bodymodel.Body"),new PParameter("RH", "org.jnect.bodymodel.RightHand"),new PParameter("RE", "org.jnect.bodymodel.RightElbow"),new PParameter("RS", "org.jnect.bodymodel.RightShoulder"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      {
      	PBody body = new PBody(this);
      	PVariable var_B = body.getOrCreateVariableByName("B");
      	PVariable var_RH = body.getOrCreateVariableByName("RH");
      	PVariable var_RE = body.getOrCreateVariableByName("RE");
      	PVariable var_RS = body.getOrCreateVariableByName("RS");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var_H = body.getOrCreateVariableByName("H");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var_RHX = body.getOrCreateVariableByName("RHX");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	PVariable var_RHY = body.getOrCreateVariableByName("RHY");
      	PVariable var__virtual_4_ = body.getOrCreateVariableByName(".virtual{4}");
      	PVariable var_RHZ = body.getOrCreateVariableByName("RHZ");
      	PVariable var__virtual_5_ = body.getOrCreateVariableByName(".virtual{5}");
      	PVariable var_REX = body.getOrCreateVariableByName("REX");
      	PVariable var__virtual_6_ = body.getOrCreateVariableByName(".virtual{6}");
      	PVariable var_REY = body.getOrCreateVariableByName("REY");
      	PVariable var__virtual_7_ = body.getOrCreateVariableByName(".virtual{7}");
      	PVariable var_REZ = body.getOrCreateVariableByName("REZ");
      	PVariable var__virtual_8_ = body.getOrCreateVariableByName(".virtual{8}");
      	PVariable var_RSX = body.getOrCreateVariableByName("RSX");
      	PVariable var__virtual_9_ = body.getOrCreateVariableByName(".virtual{9}");
      	PVariable var_RSY = body.getOrCreateVariableByName("RSY");
      	PVariable var__virtual_10_ = body.getOrCreateVariableByName(".virtual{10}");
      	PVariable var_RSZ = body.getOrCreateVariableByName("RSZ");
      	PVariable var__virtual_11_ = body.getOrCreateVariableByName(".virtual{11}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_B, "B"),
      				
      		new ExportedParameter(body, var_RH, "RH"),
      				
      		new ExportedParameter(body, var_RE, "RE"),
      				
      		new ExportedParameter(body, var_RS, "RS")
      	));
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeUnary(body, var_RH, getClassifierLiteral("http://org/jnect/bodymodel", "RightHand"), "http://org/jnect/bodymodel/RightHand");
      	new TypeUnary(body, var_RE, getClassifierLiteral("http://org/jnect/bodymodel", "RightElbow"), "http://org/jnect/bodymodel/RightElbow");
      	new TypeUnary(body, var_RS, getClassifierLiteral("http://org/jnect/bodymodel", "RightShoulder"), "http://org/jnect/bodymodel/RightShoulder");
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeBinary(body, CONTEXT, var_B, var__virtual_0_, getFeatureLiteral("http://org/jnect/bodymodel", "Body", "RightHand"), "http://org/jnect/bodymodel/Body.RightHand");
      	new Equality(body, var__virtual_0_, var_RH);
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeBinary(body, CONTEXT, var_B, var__virtual_1_, getFeatureLiteral("http://org/jnect/bodymodel", "Body", "RightElbow"), "http://org/jnect/bodymodel/Body.RightElbow");
      	new Equality(body, var__virtual_1_, var_RE);
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeBinary(body, CONTEXT, var_B, var__virtual_2_, getFeatureLiteral("http://org/jnect/bodymodel", "Body", "Head"), "http://org/jnect/bodymodel/Body.Head");
      	new Equality(body, var__virtual_2_, var_H);
      	new TypeUnary(body, var_RH, getClassifierLiteral("http://org/jnect/bodymodel", "PositionedElement"), "http://org/jnect/bodymodel/PositionedElement");
      	new TypeBinary(body, CONTEXT, var_RH, var__virtual_3_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "x"), "http://org/jnect/bodymodel/PositionedElement.x");
      	new Equality(body, var__virtual_3_, var_RHX);
      	new TypeUnary(body, var_RH, getClassifierLiteral("http://org/jnect/bodymodel", "PositionedElement"), "http://org/jnect/bodymodel/PositionedElement");
      	new TypeBinary(body, CONTEXT, var_RH, var__virtual_4_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "y"), "http://org/jnect/bodymodel/PositionedElement.y");
      	new Equality(body, var__virtual_4_, var_RHY);
      	new TypeUnary(body, var_RH, getClassifierLiteral("http://org/jnect/bodymodel", "PositionedElement"), "http://org/jnect/bodymodel/PositionedElement");
      	new TypeBinary(body, CONTEXT, var_RH, var__virtual_5_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "z"), "http://org/jnect/bodymodel/PositionedElement.z");
      	new Equality(body, var__virtual_5_, var_RHZ);
      	new TypeUnary(body, var_RE, getClassifierLiteral("http://org/jnect/bodymodel", "PositionedElement"), "http://org/jnect/bodymodel/PositionedElement");
      	new TypeBinary(body, CONTEXT, var_RE, var__virtual_6_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "x"), "http://org/jnect/bodymodel/PositionedElement.x");
      	new Equality(body, var__virtual_6_, var_REX);
      	new TypeUnary(body, var_RE, getClassifierLiteral("http://org/jnect/bodymodel", "PositionedElement"), "http://org/jnect/bodymodel/PositionedElement");
      	new TypeBinary(body, CONTEXT, var_RE, var__virtual_7_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "y"), "http://org/jnect/bodymodel/PositionedElement.y");
      	new Equality(body, var__virtual_7_, var_REY);
      	new TypeUnary(body, var_RE, getClassifierLiteral("http://org/jnect/bodymodel", "PositionedElement"), "http://org/jnect/bodymodel/PositionedElement");
      	new TypeBinary(body, CONTEXT, var_RE, var__virtual_8_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "z"), "http://org/jnect/bodymodel/PositionedElement.z");
      	new Equality(body, var__virtual_8_, var_REZ);
      	new TypeUnary(body, var_RS, getClassifierLiteral("http://org/jnect/bodymodel", "PositionedElement"), "http://org/jnect/bodymodel/PositionedElement");
      	new TypeBinary(body, CONTEXT, var_RS, var__virtual_9_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "x"), "http://org/jnect/bodymodel/PositionedElement.x");
      	new Equality(body, var__virtual_9_, var_RSX);
      	new TypeUnary(body, var_RS, getClassifierLiteral("http://org/jnect/bodymodel", "PositionedElement"), "http://org/jnect/bodymodel/PositionedElement");
      	new TypeBinary(body, CONTEXT, var_RS, var__virtual_10_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "y"), "http://org/jnect/bodymodel/PositionedElement.y");
      	new Equality(body, var__virtual_10_, var_RSY);
      	new TypeUnary(body, var_RS, getClassifierLiteral("http://org/jnect/bodymodel", "PositionedElement"), "http://org/jnect/bodymodel/PositionedElement");
      	new TypeBinary(body, CONTEXT, var_RS, var__virtual_11_, getFeatureLiteral("http://org/jnect/bodymodel", "PositionedElement", "z"), "http://org/jnect/bodymodel/PositionedElement.z");
      	new Equality(body, var__virtual_11_, var_RSZ);
      new ExpressionEvaluation(body, new IExpressionEvaluator() {
      	
      	@Override
      	public String getShortDescription() {
      		return "Expression evaluation from pattern stretchedRightArm";
      	}
      
      	@Override
      	public Iterable<String> getInputParameterNames() {
      		return Arrays.asList("REX", "REY", "REZ", "RHX", "RHY", "RHZ", "RSX", "RSY", "RSZ");
      	}
      
      	@Override
      	public Object evaluateExpression(IValueProvider provider) throws Exception {
      			java.lang.Float REX = (java.lang.Float) provider.getValue("REX");
      			java.lang.Float REY = (java.lang.Float) provider.getValue("REY");
      			java.lang.Float REZ = (java.lang.Float) provider.getValue("REZ");
      			java.lang.Float RHX = (java.lang.Float) provider.getValue("RHX");
      			java.lang.Float RHY = (java.lang.Float) provider.getValue("RHY");
      			java.lang.Float RHZ = (java.lang.Float) provider.getValue("RHZ");
      			java.lang.Float RSX = (java.lang.Float) provider.getValue("RSX");
      			java.lang.Float RSY = (java.lang.Float) provider.getValue("RSY");
      			java.lang.Float RSZ = (java.lang.Float) provider.getValue("RSZ");
      			return evaluateExpression_1_1(REX, REY, REZ, RHX, RHY, RHZ, RSX, RSY, RSZ);
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
  
  private static boolean evaluateExpression_1_1(final Float REX, final Float REY, final Float REZ, final Float RHX, final Float RHY, final Float RHZ, final Float RSX, final Float RSY, final Float RSZ) {
    boolean _xblockexpression = false;
    {
      MovingAverageCalculator _calculator = MovingAverageCalculator.getCalculator("RHX");
      MovingAverageCalculator _addValue = _calculator.addValue((RHX).floatValue());
      float _movingAvg = _addValue.getMovingAvg();
      MovingAverageCalculator _calculator_1 = MovingAverageCalculator.getCalculator("RHY");
      MovingAverageCalculator _addValue_1 = _calculator_1.addValue((RHY).floatValue());
      float _movingAvg_1 = _addValue_1.getMovingAvg();
      MovingAverageCalculator _calculator_2 = MovingAverageCalculator.getCalculator("RHZ");
      MovingAverageCalculator _addValue_2 = _calculator_2.addValue((RHZ).floatValue());
      float _movingAvg_2 = _addValue_2.getMovingAvg();
      MovingAverageCalculator _calculator_3 = MovingAverageCalculator.getCalculator("REX");
      MovingAverageCalculator _addValue_3 = _calculator_3.addValue((REX).floatValue());
      float _movingAvg_3 = _addValue_3.getMovingAvg();
      MovingAverageCalculator _calculator_4 = MovingAverageCalculator.getCalculator("REY");
      MovingAverageCalculator _addValue_4 = _calculator_4.addValue((REY).floatValue());
      float _movingAvg_4 = _addValue_4.getMovingAvg();
      MovingAverageCalculator _calculator_5 = MovingAverageCalculator.getCalculator("REZ");
      MovingAverageCalculator _addValue_5 = _calculator_5.addValue((REZ).floatValue());
      float _movingAvg_5 = _addValue_5.getMovingAvg();
      Vector<Float> _createVector = VectorMaths.createVector(_movingAvg, _movingAvg_1, _movingAvg_2, _movingAvg_3, _movingAvg_4, _movingAvg_5);
      MovingAverageCalculator _calculator_6 = MovingAverageCalculator.getCalculator("RSX");
      MovingAverageCalculator _addValue_6 = _calculator_6.addValue((RSX).floatValue());
      float _movingAvg_6 = _addValue_6.getMovingAvg();
      MovingAverageCalculator _calculator_7 = MovingAverageCalculator.getCalculator("RSY");
      MovingAverageCalculator _addValue_7 = _calculator_7.addValue((RSY).floatValue());
      float _movingAvg_7 = _addValue_7.getMovingAvg();
      MovingAverageCalculator _calculator_8 = MovingAverageCalculator.getCalculator("RSZ");
      MovingAverageCalculator _addValue_8 = _calculator_8.addValue((RSZ).floatValue());
      float _movingAvg_8 = _addValue_8.getMovingAvg();
      MovingAverageCalculator _calculator_9 = MovingAverageCalculator.getCalculator("REX");
      MovingAverageCalculator _addValue_9 = _calculator_9.addValue((REX).floatValue());
      float _movingAvg_9 = _addValue_9.getMovingAvg();
      MovingAverageCalculator _calculator_10 = MovingAverageCalculator.getCalculator("REY");
      MovingAverageCalculator _addValue_10 = _calculator_10.addValue((REY).floatValue());
      float _movingAvg_10 = _addValue_10.getMovingAvg();
      MovingAverageCalculator _calculator_11 = MovingAverageCalculator.getCalculator("REZ");
      MovingAverageCalculator _addValue_11 = _calculator_11.addValue((REZ).floatValue());
      float _movingAvg_11 = _addValue_11.getMovingAvg();
      Vector<Float> _createVector_1 = VectorMaths.createVector(_movingAvg_6, _movingAvg_7, _movingAvg_8, _movingAvg_9, _movingAvg_10, _movingAvg_11);
      float angleBetween = VectorMaths.angleBetween(_createVector, _createVector_1);
      _xblockexpression = ((Math.PI - angleBetween) < YMCAConstants.angleTolerance);
    }
    return _xblockexpression;
  }
}
