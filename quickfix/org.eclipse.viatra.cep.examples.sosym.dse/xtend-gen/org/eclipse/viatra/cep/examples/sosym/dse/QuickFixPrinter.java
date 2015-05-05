package org.eclipse.viatra.cep.examples.sosym.dse;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.api.Solution;
import org.eclipse.viatra.dse.api.SolutionTrajectory;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class QuickFixPrinter {
  public static void printQuickFixes(final Collection<Solution> solutions) {
    int i = 1;
    final Iterator<Solution> iterator = solutions.iterator();
    while (iterator.hasNext()) {
      {
        final Solution solution = iterator.next();
        final SolutionTrajectory solutionTrajectory = solution.getArbitraryTrajectory();
        final List<DSETransformationRule<?, ?>> transformationRules = solutionTrajectory.getTransformationRules();
        String _format = String.format("[%d] ", Integer.valueOf(i));
        InputOutput.<String>print(_format);
        DSETransformationRule<?, ?> _head = IterableExtensions.<DSETransformationRule<?, ?>>head(transformationRules);
        String _ruleName = _head.getRuleName();
        InputOutput.<String>print(_ruleName);
        Iterable<DSETransformationRule<?, ?>> _tail = IterableExtensions.<DSETransformationRule<?, ?>>tail(transformationRules);
        for (final DSETransformationRule<?, ?> transformationRule : _tail) {
          String _ruleName_1 = transformationRule.getRuleName();
          String _plus = (" -> " + _ruleName_1);
          InputOutput.<String>print(_plus);
        }
        InputOutput.println();
        i++;
      }
    }
  }
}
