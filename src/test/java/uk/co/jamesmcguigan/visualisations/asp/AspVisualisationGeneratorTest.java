package uk.co.jamesmcguigan.visualisations.asp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

public class AspVisualisationGeneratorTest {

    private AspVisualisationGenerator aspVisualisationGenerator;
    private String location = "C:\\code\\travelinsurance\\src\\main\\admin_classic_asp";
    @Mock
    private AbstractEntityRepository pageRepository;

    @Before
    public void setUp() {
        aspVisualisationGenerator = new AspVisualisationGenerator();
    }

    @Test
    public void doSOmething() {
        aspVisualisationGenerator.create(location);
    }
}
