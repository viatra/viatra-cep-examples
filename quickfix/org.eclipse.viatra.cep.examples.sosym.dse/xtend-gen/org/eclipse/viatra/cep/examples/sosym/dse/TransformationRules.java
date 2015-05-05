package org.eclipse.viatra.cep.examples.sosym.dse;

import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.HostInstance;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpu2Match;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpu2Matcher;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpuMatch;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalCpuMatcher;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalHddMatch;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalHddMatcher;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalRamMatch;
import org.eclipse.viatra.cep.examples.sosym.queries.AvailableGreaterThanTotalRamMatcher;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpu2Processor;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpu2QuerySpecification;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpuProcessor;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalCpuQuerySpecification;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalHddProcessor;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalHddQuerySpecification;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalRamProcessor;
import org.eclipse.viatra.cep.examples.sosym.queries.util.AvailableGreaterThanTotalRamQuerySpecification;
import org.eclipse.viatra.dse.api.DSETransformationRule;
import org.eclipse.viatra.dse.api.DesignSpaceExplorer;
import org.eclipse.xtext.xbase.lib.Exceptions;

@SuppressWarnings("all")
public class TransformationRules {
  public static void setTransformationRules(final DesignSpaceExplorer dse) {
    try {
      AvailableGreaterThanTotalCpuQuerySpecification _instance = AvailableGreaterThanTotalCpuQuerySpecification.instance();
      DSETransformationRule<AvailableGreaterThanTotalCpuMatch, AvailableGreaterThanTotalCpuMatcher> _dSETransformationRule = new DSETransformationRule<AvailableGreaterThanTotalCpuMatch, AvailableGreaterThanTotalCpuMatcher>(
        "decreaseAvailableCpuToTotal", _instance, 
        new AvailableGreaterThanTotalCpuProcessor() {
          @Override
          public void process(final HostInstance pHost) {
            int _totalCpu = pHost.getTotalCpu();
            pHost.setAvailableCpu(_totalCpu);
          }
        });
      dse.addTransformationRule(_dSETransformationRule);
      AvailableGreaterThanTotalCpu2QuerySpecification _instance_1 = AvailableGreaterThanTotalCpu2QuerySpecification.instance();
      DSETransformationRule<AvailableGreaterThanTotalCpu2Match, AvailableGreaterThanTotalCpu2Matcher> _dSETransformationRule_1 = new DSETransformationRule<AvailableGreaterThanTotalCpu2Match, AvailableGreaterThanTotalCpu2Matcher>(
        "increaseTotalCpuToAvailable", _instance_1, 
        new AvailableGreaterThanTotalCpu2Processor() {
          @Override
          public void process(final HostInstance pHost) {
            int _availableCpu = pHost.getAvailableCpu();
            pHost.setTotalCpu(_availableCpu);
          }
        });
      dse.addTransformationRule(_dSETransformationRule_1);
      AvailableGreaterThanTotalHddQuerySpecification _instance_2 = AvailableGreaterThanTotalHddQuerySpecification.instance();
      DSETransformationRule<AvailableGreaterThanTotalHddMatch, AvailableGreaterThanTotalHddMatcher> _dSETransformationRule_2 = new DSETransformationRule<AvailableGreaterThanTotalHddMatch, AvailableGreaterThanTotalHddMatcher>(
        "decreaseAvailableHddToTotal", _instance_2, 
        new AvailableGreaterThanTotalHddProcessor() {
          @Override
          public void process(final HostInstance pHost) {
            int _totalHdd = pHost.getTotalHdd();
            pHost.setAvailableHdd(_totalHdd);
          }
        });
      dse.addTransformationRule(_dSETransformationRule_2);
      AvailableGreaterThanTotalRamQuerySpecification _instance_3 = AvailableGreaterThanTotalRamQuerySpecification.instance();
      DSETransformationRule<AvailableGreaterThanTotalRamMatch, AvailableGreaterThanTotalRamMatcher> _dSETransformationRule_3 = new DSETransformationRule<AvailableGreaterThanTotalRamMatch, AvailableGreaterThanTotalRamMatcher>(
        "decreaseAvailableRamToTotal", _instance_3, 
        new AvailableGreaterThanTotalRamProcessor() {
          @Override
          public void process(final HostInstance pHost) {
            int _totalRam = pHost.getTotalRam();
            pHost.setAvailableRam(_totalRam);
          }
        });
      dse.addTransformationRule(_dSETransformationRule_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
