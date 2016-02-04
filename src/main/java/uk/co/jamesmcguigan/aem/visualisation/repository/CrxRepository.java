package uk.co.jamesmcguigan.aem.visualisation.repository;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface CrxRepository {

    public void createSession() throws RepositoryException;
    public Node getNode(String path) throws RepositoryException;
}
