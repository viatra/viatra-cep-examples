package bodymodel.ymca.util;

import bodymodel.ymca.FSMatch;
import org.eclipse.incquery.runtime.api.IMatchProcessor;
import org.jnect.bodymodel.Body;
import org.jnect.bodymodel.Head;
import org.jnect.bodymodel.RightElbow;
import org.jnect.bodymodel.RightHand;
import org.jnect.bodymodel.RightShoulder;

/**
 * A match processor tailored for the bodymodel.ymca.FS pattern.
 * 
 * Clients should derive an (anonymous) class that implements the abstract process().
 * 
 */
@SuppressWarnings("all")
public abstract class FSProcessor implements IMatchProcessor<FSMatch> {
  /**
   * Defines the action that is to be executed on each match.
   * @param pB the value of pattern parameter B in the currently processed match
   * @param pRH the value of pattern parameter RH in the currently processed match
   * @param pRE the value of pattern parameter RE in the currently processed match
   * @param pRS the value of pattern parameter RS in the currently processed match
   * @param pH the value of pattern parameter H in the currently processed match
   * 
   */
  public abstract void process(final Body pB, final RightHand pRH, final RightElbow pRE, final RightShoulder pRS, final Head pH);
  
  @Override
  public void process(final FSMatch match) {
    process(match.getB(), match.getRH(), match.getRE(), match.getRS(), match.getH());
  }
}
