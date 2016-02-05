package uk.co.jamesmcguigan.aem.visualisation.facade;

import org.junit.Test;
import uk.co.jamesmcguigan.aem.visualisation.facade.impl.CrxFacadeImpl;
import uk.co.jamesmcguigan.aem.visualisation.repository.CrxRepository;
import uk.co.jamesmcguigan.aem.visualisation.repository.EntityRepository;
import uk.co.jamesmcguigan.aem.visualisation.repository.impl.CrxRepositoryImpl;
import uk.co.jamesmcguigan.aem.visualisation.repository.impl.EntityRepositoryImpl;

import javax.jcr.RepositoryException;

public class CrxFacadeTest {

    @Test
    public void shouldTraverseCrxStructure() throws RepositoryException {
        CrxRepository crxRepository = new CrxRepositoryImpl();
        CrxFacade crxFacade = new CrxFacadeImpl(crxRepository);
        crxFacade.createCrxRepresentation();
    }


}
