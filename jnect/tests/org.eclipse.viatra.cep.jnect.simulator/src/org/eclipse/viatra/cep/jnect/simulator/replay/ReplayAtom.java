package org.eclipse.viatra.cep.jnect.simulator.replay;

import java.util.List;

import org.jnect.core.impl.capture.persistence.Change;

import com.google.common.collect.Lists;

public class ReplayAtom {
    private List<Change> atomicChange = Lists.newArrayList();

    public ReplayAtom(List<Change> atomicChange) {
        this.atomicChange = atomicChange;
    }
    
    public List<Change> getAtomicChange() {
        return atomicChange;
    }
}
