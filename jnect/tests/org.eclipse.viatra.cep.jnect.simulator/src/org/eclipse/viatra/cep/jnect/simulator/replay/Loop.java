package org.eclipse.viatra.cep.jnect.simulator.replay;

import java.util.List;

import com.google.common.collect.Lists;

public class Loop {
    private List<ReplayAtom> atoms = Lists.newArrayList();

    public Loop(List<ReplayAtom> atoms) {
        super();
        this.atoms = atoms;
    }

    public List<ReplayAtom> getAtoms() {
        return atoms;
    }
}
