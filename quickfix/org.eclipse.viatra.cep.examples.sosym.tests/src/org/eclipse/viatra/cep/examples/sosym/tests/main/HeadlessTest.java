package org.eclipse.viatra.cep.examples.sosym.tests.main;

import org.eclipse.viatra.cep.examples.sosym.tests.internal.DefaultRealm;
import org.junit.After;
import org.junit.Before;

public abstract class HeadlessTest {
    private DefaultRealm defaultRealm;

    @Before
    public void setUpDefaultRealm() {
        defaultRealm = new DefaultRealm();
    }

    @After
    public void tearDownDefaultRealm() {
        defaultRealm.dispose();
    }
}
