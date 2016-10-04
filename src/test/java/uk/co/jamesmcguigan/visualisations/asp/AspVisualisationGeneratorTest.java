package uk.co.jamesmcguigan.visualisations.asp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

public class AspVisualisationGeneratorTest {

    private AspVisualisationGenerator aspVisualisationGenerator;
    private String location;
    @Mock
    private AbstractEntityRepository pageRepository;

    @Before
    public void setUp() {
        aspVisualisationGenerator = new AspVisualisationGenerator(location);
    }

    @Test
    public void doSOmething() {
        when(pageRepository.createOrUpdate(entity));



        aspVisualisationGenerator.create();
    }
}
