package com.rh12.tbcep.queries;

import com.rh12.tbcep.queries.JumpAMatcher;
import com.rh12.tbcep.queries.JumpBMatcher;
import com.rh12.tbcep.queries.JumpCMatcher;
import com.rh12.tbcep.queries.JumpDMatcher;
import com.rh12.tbcep.queries.JumpEMatcher;
import com.rh12.tbcep.queries.JumpFMatcher;
import com.rh12.tbcep.queries.JumpHMatcher;
import com.rh12.tbcep.queries.SensorZMinusMatcher;
import com.rh12.tbcep.queries.SensorZPlusMatcher;
import com.rh12.tbcep.queries.util.JumpAQuerySpecification;
import com.rh12.tbcep.queries.util.JumpBQuerySpecification;
import com.rh12.tbcep.queries.util.JumpCQuerySpecification;
import com.rh12.tbcep.queries.util.JumpDQuerySpecification;
import com.rh12.tbcep.queries.util.JumpEQuerySpecification;
import com.rh12.tbcep.queries.util.JumpFQuerySpecification;
import com.rh12.tbcep.queries.util.JumpHQuerySpecification;
import com.rh12.tbcep.queries.util.SensorZMinusQuerySpecification;
import com.rh12.tbcep.queries.util.SensorZPlusQuerySpecification;
import org.eclipse.incquery.runtime.api.IncQueryEngine;
import org.eclipse.incquery.runtime.api.impl.BaseGeneratedPatternGroup;
import org.eclipse.incquery.runtime.exception.IncQueryException;

/**
 * A pattern group formed of all patterns defined in queries.eiq.
 * 
 * <p>Use the static instance as any {@link org.eclipse.incquery.runtime.api.IPatternGroup}, to conveniently prepare
 * an EMF-IncQuery engine for matching all patterns originally defined in file queries.eiq,
 * in order to achieve better performance than one-by-one on-demand matcher initialization.
 * 
 * <p> From package com.rh12.tbcep.queries, the group contains the definition of the following patterns: <ul>
 * <li>jumpA</li>
 * <li>jumpB</li>
 * <li>jumpC</li>
 * <li>jumpD</li>
 * <li>jumpE</li>
 * <li>jumpF</li>
 * <li>jumpH</li>
 * <li>sensorZPlus</li>
 * <li>sensorZMinus</li>
 * </ul>
 * 
 * @see IPatternGroup
 * 
 */
@SuppressWarnings("all")
public final class Queries extends BaseGeneratedPatternGroup {
  /**
   * Access the pattern group.
   * 
   * @return the singleton instance of the group
   * @throws IncQueryException if there was an error loading the generated code of pattern specifications
   * 
   */
  public static Queries instance() throws IncQueryException {
    if (INSTANCE == null) {
    	INSTANCE = new Queries();
    }
    return INSTANCE;
  }
  
  private static Queries INSTANCE;
  
  private Queries() throws IncQueryException {
    querySpecifications.add(JumpAQuerySpecification.instance());
    querySpecifications.add(JumpBQuerySpecification.instance());
    querySpecifications.add(JumpCQuerySpecification.instance());
    querySpecifications.add(JumpDQuerySpecification.instance());
    querySpecifications.add(JumpEQuerySpecification.instance());
    querySpecifications.add(JumpFQuerySpecification.instance());
    querySpecifications.add(JumpHQuerySpecification.instance());
    querySpecifications.add(SensorZPlusQuerySpecification.instance());
    querySpecifications.add(SensorZMinusQuerySpecification.instance());
  }
  
  public JumpAQuerySpecification getJumpA() throws IncQueryException {
    return JumpAQuerySpecification.instance();
  }
  
  public JumpAMatcher getJumpA(final IncQueryEngine engine) throws IncQueryException {
    return JumpAMatcher.on(engine);
  }
  
  public JumpBQuerySpecification getJumpB() throws IncQueryException {
    return JumpBQuerySpecification.instance();
  }
  
  public JumpBMatcher getJumpB(final IncQueryEngine engine) throws IncQueryException {
    return JumpBMatcher.on(engine);
  }
  
  public JumpCQuerySpecification getJumpC() throws IncQueryException {
    return JumpCQuerySpecification.instance();
  }
  
  public JumpCMatcher getJumpC(final IncQueryEngine engine) throws IncQueryException {
    return JumpCMatcher.on(engine);
  }
  
  public JumpDQuerySpecification getJumpD() throws IncQueryException {
    return JumpDQuerySpecification.instance();
  }
  
  public JumpDMatcher getJumpD(final IncQueryEngine engine) throws IncQueryException {
    return JumpDMatcher.on(engine);
  }
  
  public JumpEQuerySpecification getJumpE() throws IncQueryException {
    return JumpEQuerySpecification.instance();
  }
  
  public JumpEMatcher getJumpE(final IncQueryEngine engine) throws IncQueryException {
    return JumpEMatcher.on(engine);
  }
  
  public JumpFQuerySpecification getJumpF() throws IncQueryException {
    return JumpFQuerySpecification.instance();
  }
  
  public JumpFMatcher getJumpF(final IncQueryEngine engine) throws IncQueryException {
    return JumpFMatcher.on(engine);
  }
  
  public JumpHQuerySpecification getJumpH() throws IncQueryException {
    return JumpHQuerySpecification.instance();
  }
  
  public JumpHMatcher getJumpH(final IncQueryEngine engine) throws IncQueryException {
    return JumpHMatcher.on(engine);
  }
  
  public SensorZPlusQuerySpecification getSensorZPlus() throws IncQueryException {
    return SensorZPlusQuerySpecification.instance();
  }
  
  public SensorZPlusMatcher getSensorZPlus(final IncQueryEngine engine) throws IncQueryException {
    return SensorZPlusMatcher.on(engine);
  }
  
  public SensorZMinusQuerySpecification getSensorZMinus() throws IncQueryException {
    return SensorZMinusQuerySpecification.instance();
  }
  
  public SensorZMinusMatcher getSensorZMinus(final IncQueryEngine engine) throws IncQueryException {
    return SensorZMinusMatcher.on(engine);
  }
}
