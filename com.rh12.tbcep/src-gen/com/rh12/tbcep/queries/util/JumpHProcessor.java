package com.rh12.tbcep.queries.util;

import com.rh12.tbcep.queries.JumpHMatch;
import model.Sensor;
import org.eclipse.incquery.runtime.api.IMatchProcessor;

/**
 * A match processor tailored for the com.rh12.tbcep.queries.jumpH pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class JumpHProcessor implements IMatchProcessor<JumpHMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pSensor the value of pattern parameter sensor in the currently processed match
   * 
   */
  public abstract void process(final Sensor pSensor);
  
  @Override
  public void process(final JumpHMatch match) {
    process(match.getSensor());
  }
}
