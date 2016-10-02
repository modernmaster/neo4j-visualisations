package uk.co.jamesmcguigan.visualisation.aem;

import org.junit.Test;
import uk.co.jamesmcguigan.visualisation.VisualisationGenerator;
import uk.co.jamesmcguigan.visualisation.aem.repository.ContentRepository;
import uk.co.jamesmcguigan.visualisation.aem.repository.ContentRepositoryImpl;

import javax.jcr.RepositoryException;

public class VisualisationGeneratorTest {

    @Test
    public void shouldTraverseCrxStructure() throws RepositoryException {
        ContentRepository contentRepository = new ContentRepositoryImpl();
        VisualisationGenerator crxFacade = new AEMVisualationGenerator(contentRepository);
        crxFacade.create();
    }


}
