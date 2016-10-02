package uk.co.jamesmcguigan.visualisations.asp;

import org.junit.Before;
import org.junit.Test;

public class AspVisualisationGeneratorTest {

    private AspVisualisationGenerator aspVisualisationGenerator;

    @Before
    public void setUp() {
        aspVisualisationGenerator = new AspVisualisationGenerator();
    }

    @Test
    public void doSOmething() {
        aspVisualisationGenerator.create();
    }
}
