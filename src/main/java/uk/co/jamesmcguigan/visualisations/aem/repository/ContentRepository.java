package uk.co.jamesmcguigan.visualisations.aem.repository;

import javax.jcr.Node;
import javax.jcr.RepositoryException;

public interface ContentRepository {

    void createSession() throws RepositoryException;
    Node getNode(String path) throws RepositoryException;
}
