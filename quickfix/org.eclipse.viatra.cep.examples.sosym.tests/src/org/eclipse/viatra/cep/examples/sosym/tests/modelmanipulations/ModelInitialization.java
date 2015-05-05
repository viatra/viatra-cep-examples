package org.eclipse.viatra.cep.examples.sosym.tests.modelmanipulations;

import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.CyberPhysicalSystem;
import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.CyberPhysicalSystemFactory;
import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.HostInstance;
import org.eclipse.incquery.examples.cps.cyberPhysicalSystem.HostType;

public class ModelInitialization {

    public static void initializeSource(CyberPhysicalSystem source) {
        HostType hostType1 = CyberPhysicalSystemFactory.eINSTANCE.createHostType();
        source.getHostTypes().add(hostType1);
        
        HostInstance hostInstance1 = CyberPhysicalSystemFactory.eINSTANCE.createHostInstance();
        hostInstance1.setNodeIp("192.168.1.10");
        hostInstance1.setTotalCpu(5);
//        hostInstance1.setAvailableCpu(10);
        hostInstance1.setTotalHdd(5);
        hostInstance1.setAvailableHdd(10);
        hostType1.getInstances().add(hostInstance1);
    }
}
