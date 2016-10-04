package uk.co.jamesmcguigan.visualisations.aem;

import org.junit.Ignore;
import org.junit.Test;
import uk.co.jamesmcguigan.visualisations.VisualisationGenerator;
import uk.co.jamesmcguigan.visualisations.aem.repository.ContentRepository;
import uk.co.jamesmcguigan.visualisations.aem.repository.ContentRepositoryImpl;

import javax.jcr.RepositoryException;

public class VisualisationGeneratorTest {

    @Ignore
    @Test
    public void shouldTraverseCrxStructure() throws RepositoryException {
        ContentRepository contentRepository = new ContentRepositoryImpl();
        VisualisationGenerator crxFacade = new AEMVisualationGenerator(contentRepository);
        crxFacade.create();
    }


}
