package org.eclipse.viatra.cep.examples.sosym.dse

import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.HostInstance
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpu2Match
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpu2Matcher
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpuMatch
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpuMatcher
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalHddMatch
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalHddMatcher
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalRamMatch
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalRamMatcher
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpu2Processor
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpu2QuerySpecification
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpuProcessor
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpuQuerySpecification
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalHddProcessor
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalHddQuerySpecification
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalRamProcessor
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalRamQuerySpecification
import org.eclipse.viatra.dse.api.DSETransformationRule
import org.eclipse.viatra.dse.api.DesignSpaceExplorer

class TransformationRules {
	def public static setTransformationRules(DesignSpaceExplorer dse) {
		dse.addTransformationRule(
			new DSETransformationRule<AvailableGreaterThanTotalCpuMatch, AvailableGreaterThanTotalCpuMatcher>(
				"decreaseAvailableCpuToTotal", AvailableGreaterThanTotalCpuQuerySpecification.instance(),
				new AvailableGreaterThanTotalCpuProcessor() {
					override process(HostInstance pHost) {
						pHost.setAvailableCpu(pHost.getTotalCpu());
					}
				}));

		dse.addTransformationRule(
			new DSETransformationRule<AvailableGreaterThanTotalCpu2Match, AvailableGreaterThanTotalCpu2Matcher>(
				"increaseTotalCpuToAvailable", AvailableGreaterThanTotalCpu2QuerySpecification.instance(),
				new AvailableGreaterThanTotalCpu2Processor() {
					override process(HostInstance pHost) {
						pHost.setTotalCpu(pHost.getAvailableCpu());
					}
				}));

		dse.addTransformationRule(
			new DSETransformationRule<AvailableGreaterThanTotalHddMatch, AvailableGreaterThanTotalHddMatcher>(
				"decreaseAvailableHddToTotal", AvailableGreaterThanTotalHddQuerySpecification.instance(),
				new AvailableGreaterThanTotalHddProcessor() {
					override process(HostInstance pHost) {
						pHost.setAvailableHdd(pHost.getTotalHdd());
					}
				}));

		dse.addTransformationRule(
			new DSETransformationRule<AvailableGreaterThanTotalRamMatch, AvailableGreaterThanTotalRamMatcher>(
				"decreaseAvailableRamToTotal", AvailableGreaterThanTotalRamQuerySpecification.instance(),
				new AvailableGreaterThanTotalRamProcessor() {
					override process(HostInstance pHost) {
						pHost.setAvailableRam(pHost.getTotalRam());
					}
				}));
	}
}