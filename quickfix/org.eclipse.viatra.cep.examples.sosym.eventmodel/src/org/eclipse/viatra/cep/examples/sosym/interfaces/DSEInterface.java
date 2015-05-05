package org.eclipse.viatra.cep.examples.sosym.interfaces;

import java.util.Collection;

import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.viatra.cep.examples.sosym.dse.QuickFixGeneration;
import org.eclipse.viatra.cep.examples.sosym.dse.QuickFixPrinter;
import org.eclipse.viatra.dse.api.Solution;

public class DSEInterface {
    private static DSEInterface instance;

    public static DSEInterface getInstance() {
        if (instance == null) {
            instance = new DSEInterface();
        }
        return instance;
    }

    public void generateCandidates() throws IncQueryException {
        Collection<Solution> quickFixCandidates = QuickFixGeneration.getInstance().generateQuickFixes();
        QuickFixPrinter.printQuickFixes(quickFixCandidates);
    }
}
