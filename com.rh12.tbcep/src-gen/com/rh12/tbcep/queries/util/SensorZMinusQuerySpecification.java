package com.rh12.tbcep.queries.util;

import com.google.common.collect.Sets;
import com.rh12.tbcep.queries.SensorZMinusMatch;
import com.rh12.tbcep.queries.SensorZMinusMatcher;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFPQuery;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedEMFQuerySpecification;
import org.eclipse.incquery.runtime.emf.types.EClassTransitiveInstancesKey;
import org.eclipse.incquery.runtime.emf.types.EStructuralFeatureInstancesKey;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.eclipse.incquery.runtime.matchers.psystem.PBody;
import org.eclipse.incquery.runtime.matchers.psystem.PVariable;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.Equality;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExportedParameter;
import org.eclipse.incquery.runtime.matchers.psystem.basicdeferred.ExpressionEvaluation;
import org.eclipse.incquery.runtime.matchers.psystem.basicenumerables.TypeConstraint;
import org.eclipse.incquery.runtime.matchers.psystem.queries.PParameter;
import org.eclipse.incquery.runtime.matchers.psystem.queries.QueryInitializationException;
import org.eclipse.incquery.runtime.matchers.tuple.FlatTuple;

/**
 * A pattern-specific query specification that can instantiate SensorZMinusMatcher in a type-safe way.
 * 
 * @see SensorZMinusMatcher
 * @see SensorZMinusMatch
 * 
 */
@SuppressWarnings("all")
public final class SensorZMinusQuerySpecification extends BaseGeneratedEMFQuerySpecification<SensorZMinusMatcher> {
  private SensorZMinusQuerySpecification() {
    super(GeneratedPQuery.INSTANCE);
  }
  
  /**
   * @return the singleton instance of the query specification
   * @throws IncQueryException if the pattern definition could not be loaded
   * 
   */
  public static SensorZMinusQuerySpecification instance() throws IncQueryException {
    try{
    	return LazyHolder.INSTANCE;
    } catch (ExceptionInInitializerError err) {
    	throw processInitializerError(err);
    }
  }
  
  @Override
  protected SensorZMinusMatcher instantiate(final IncQueryEngine engine) throws IncQueryException {
    return SensorZMinusMatcher.on(engine);
  }
  
  @Override
  public SensorZMinusMatch newEmptyMatch() {
    return SensorZMinusMatch.newEmptyMatch();
  }
  
  @Override
  public SensorZMinusMatch newMatch(final Object... parameters) {
    return SensorZMinusMatch.newMatch((model.Sensor) parameters[0]);
  }
  
  private static class LazyHolder {
    private final static SensorZMinusQuerySpecification INSTANCE = make();
    
    public static SensorZMinusQuerySpecification make() {
      return new SensorZMinusQuerySpecification();					
    }
  }
  
  private static class GeneratedPQuery extends BaseGeneratedEMFPQuery {
    private final static SensorZMinusQuerySpecification.GeneratedPQuery INSTANCE = new GeneratedPQuery();
    
    @Override
    public String getFullyQualifiedName() {
      return "com.rh12.tbcep.queries.sensorZMinus";
    }
    
    @Override
    public List<String> getParameterNames() {
      return Arrays.asList("sensor");
    }
    
    @Override
    public List<PParameter> getParameters() {
      return Arrays.asList(new PParameter("sensor", "model.Sensor"));
    }
    
    @Override
    public Set<PBody> doGetContainedBodies() throws QueryInitializationException {
      Set<PBody> bodies = Sets.newLinkedHashSet();
      try {
      	{
      		PBody body = new PBody(this);
      		PVariable var_sensor = body.getOrCreateVariableByName("sensor");
      		PVariable var_z = body.getOrCreateVariableByName("z");
      		new TypeConstraint(body, new FlatTuple(var_sensor), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("com.rh12.tbcep.model", "Sensor")));
      		body.setSymbolicParameters(Arrays.<ExportedParameter>asList(
      		   new ExportedParameter(body, var_sensor, "sensor")
      		));
      		// 	Sensor.values.z(sensor, z)
      		new TypeConstraint(body, new FlatTuple(var_sensor), new EClassTransitiveInstancesKey((EClass)getClassifierLiteral("com.rh12.tbcep.model", "Sensor")));
      		PVariable var__virtual_0_ = body.getOrCreateVariableByName(".virtual{0}");
      		new TypeConstraint(body, new FlatTuple(var_sensor, var__virtual_0_), new EStructuralFeatureInstancesKey(getFeatureLiteral("com.rh12.tbcep.model", "Sensor", "values")));
      		PVariable var__virtual_1_ = body.getOrCreateVariableByName(".virtual{1}");
      		new TypeConstraint(body, new FlatTuple(var__virtual_0_, var__virtual_1_), new EStructuralFeatureInstancesKey(getFeatureLiteral("com.rh12.tbcep.model", "Vector", "z")));
      		new Equality(body, var__virtual_1_, var_z);
      		// 	check(z < -1.5)
      		new ExpressionEvaluation(body, new IExpressionEvaluator() {
      		                            
      		                            @Override
      		                            public String getShortDescription() {
      		                                return "Expression evaluation from pattern sensorZMinus";
      		                            }
      		
      		                            @Override
      		                            public Iterable<String> getInputParameterNames() {
      		                                return Arrays.asList("z");
      		                            }
      		
      		                            @Override
      		                            public Object evaluateExpression(IValueProvider provider) throws Exception {
      		                                    java.lang.Double z = (java.lang.Double) provider.getValue("z");
      		                                    return evaluateExpression_1_1(z);
      		                                }
      		
      		                        },  null); 
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
  
  private static boolean evaluateExpression_1_1(final Double z) {
    return ((z).doubleValue() < (-1.5));
  }
}
