package uk.co.jamesmcguigan.aem.visualisation.repository;

import org.junit.Before;
import org.junit.Test;
import uk.co.jamesmcguigan.aem.visualisation.repository.impl.CrxRepositoryImpl;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

import static org.junit.Assert.assertEquals;

public class CrxRepositoryTest {

    private CrxRepository crxRepository;

    @Before
    public void Setup() throws RepositoryException {
        crxRepository = new CrxRepositoryImpl();
        crxRepository.createSession();
    }

    @Test
    public void testWillGetNode() throws RepositoryException {
        String path = "/content";
        Node requestedNode = crxRepository.getNode(path);
        assertEquals(requestedNode.getPath(), path);
    }

}
