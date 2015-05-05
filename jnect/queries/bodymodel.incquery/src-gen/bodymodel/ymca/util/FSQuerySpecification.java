package bodymodel.ymca.util;

import bodymodel.ymca.FSMatch;
import bodymodel.ymca.FSMatcher;
import bodymodel.ymca.util.RightHandAboveHeadQuerySpecification;
import bodymodel.ymca.util.StretchedRightArmQuerySpecification;
import com.google.common.collect.Sets;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.NegativePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.PositivePatternCall;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeBinary;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeUnary;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate FSMatcher in a type-safe way.
 * 
 * @see FSMatcher
 * @see FSMatch
 * 
 */
@SuppressWarnings("all")
public final class FSQuerySpecification extends BaseGeneratedEMFQuerySpecification<FSMatcher> {
  private FSQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static FSQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected FSMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return FSMatcher.on(engine);
  }
  
  @Override
  public FSMatch newEmptyMatch() {
    return FSMatch.newEmptyMatch();
  }
  
  @Override
  public FSMatch newMatch(final Object... parameters) {
    return FSMatch.newMatch((org.jnect.bodymodel.Body) parameters[0], (org.jnect.bodymodel.RightHand) parameters[1], (org.jnect.bodymodel.RightElbow) parameters[2], (org.jnect.bodymodel.RightShoulder) parameters[3], (org.jnect.bodymodel.Head) parameters[4]);
  }
  
  private static class LazyHolder {
    private final static FSQuerySpecification INSTANCE = make();
    
    public static FSQuerySpecification make() {
      return new FSQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static FSQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "bodymodel.ymca.FS";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("B","RH","RE","RS","H");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("B", "org.jnect.bodymodel.Body"),new PParameter("RH", "org.jnect.bodymodel.RightHand"),new PParameter("RE", "org.jnect.bodymodel.RightElbow"),new PParameter("RS", "org.jnect.bodymodel.RightShoulder"),new PParameter("H", "org.jnect.bodymodel.Head"));
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
      	PVariable var_H = body.getOrCreateVariableByName("H");
      	PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      	PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      	PVariable var__virtual_2_ = body.getOrCreateVariableByName(".virtual{2}");
      	PVariable var__virtual_3_ = body.getOrCreateVariableByName(".virtual{3}");
      	body.setExportedParameters(Arrays.<ExportedParameter>asList(
      		new ExportedParameter(body, var_B, "B"),
      				
      		new ExportedParameter(body, var_RH, "RH"),
      				
      		new ExportedParameter(body, var_RE, "RE"),
      				
      		new ExportedParameter(body, var_RS, "RS"),
      				
      		new ExportedParameter(body, var_H, "H")
      	));
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeUnary(body, var_RH, getClassifierLiteral("http://org/jnect/bodymodel", "RightHand"), "http://org/jnect/bodymodel/RightHand");
      	new TypeUnary(body, var_RE, getClassifierLiteral("http://org/jnect/bodymodel", "RightElbow"), "http://org/jnect/bodymodel/RightElbow");
      	new TypeUnary(body, var_RS, getClassifierLiteral("http://org/jnect/bodymodel", "RightShoulder"), "http://org/jnect/bodymodel/RightShoulder");
      	new TypeUnary(body, var_H, getClassifierLiteral("http://org/jnect/bodymodel", "Head"), "http://org/jnect/bodymodel/Head");
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeBinary(body, CONTEXT, var_B, var__virtual_0_, getFeatureLiteral("http://org/jnect/bodymodel", "Body", "RightHand"), "http://org/jnect/bodymodel/Body.RightHand");
      	new Equality(body, var__virtual_0_, var_RH);
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeBinary(body, CONTEXT, var_B, var__virtual_1_, getFeatureLiteral("http://org/jnect/bodymodel", "Body", "RightElbow"), "http://org/jnect/bodymodel/Body.RightElbow");
      	new Equality(body, var__virtual_1_, var_RE);
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeBinary(body, CONTEXT, var_B, var__virtual_2_, getFeatureLiteral("http://org/jnect/bodymodel", "Body", "RightShoulder"), "http://org/jnect/bodymodel/Body.RightShoulder");
      	new Equality(body, var__virtual_2_, var_RS);
      	new TypeUnary(body, var_B, getClassifierLiteral("http://org/jnect/bodymodel", "Body"), "http://org/jnect/bodymodel/Body");
      	new TypeBinary(body, CONTEXT, var_B, var__virtual_3_, getFeatureLiteral("http://org/jnect/bodymodel", "Body", "Head"), "http://org/jnect/bodymodel/Body.Head");
      	new Equality(body, var__virtual_3_, var_H);
      	new PositivePatternCall(body, new FlatTuple(var_B, var_RH, var_RE, var_RS), StretchedRightArmQuerySpecification.instance().getInternalQueryRepresentation());
      	new NegativePatternCall(body, new FlatTuple(var_B, var_RH, var_H), RightHandAboveHeadQuerySpecification.instance().getInternalQueryRepresentation());
      	bodies.add(body);
      }
      	// to silence compiler error
      	if (false) throw new IncQueryException("Never", "happens");
      } catch (IncQueryException ex) {
      	throw processDependencyException(ex);
      }
      return bodies;
    }
  }
}
