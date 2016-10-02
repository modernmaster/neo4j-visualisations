package uk.co.jamesmcguigan.visualisations.aem.repository;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ContentRepository {

    public void createSession() throws RepositoryException;
    public Node getNode(String path) throws RepositoryException;
}
