package uk.co.jamesmcguigan.visualisations.infrastructure;

import org.junit.Before;
import org.junit.Test;
import uk.co.jamesmcguigan.visualisations.aem.repository.ContentRepository;
import uk.co.jamesmcguigan.visualisations.aem.repository.ContentRepositoryImpl;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import static org.junit.Assert.assertEquals;

public class ContentRepositoryTest {

    private ContentRepository contentRepository;

    @Before
    public void Setup() throws RepositoryException {
        contentRepository = new ContentRepositoryImpl();
        contentRepository.createSession();
    }

    @Test
    @Ignore
    public void testWillGetNode() throws RepositoryException {
        String path = "/content";
        Node requestedNode = contentRepository.getNode(path);
        assertEquals(requestedNode.getPath(), path);
    }

}
