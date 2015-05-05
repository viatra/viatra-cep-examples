package org.eclipse.viatra.cep.examples.sosym.dse

import java.util.Collection
import org.eclipse.viatra.dse.api.Solution

class QuickFixPrinter {
	def public static printQuickFixes(Collection<Solution> solutions) {
		var i = 1

		val iterator = solutions.iterator
		while (iterator.hasNext) {
			val solution = iterator.next
			val solutionTrajectory = solution.arbitraryTrajectory
			val transformationRules = solutionTrajectory.transformationRules

			print(String.format("[%d] ", i))

			print(transformationRules.head.ruleName)
			for (transformationRule : transformationRules.tail) {
				print(" -> " + transformationRule.ruleName)
			}
			println()
			i++;
		}
	}

}