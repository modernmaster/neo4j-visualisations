package uk.co.jamesmcguigan.visualisations.aem.repository;

import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.Node;
import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;


public class ContentRepositoryImpl implements ContentRepository {

    private Session session;
    private static final String HOST = "2674-w7e";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";
    private static final String CONTEXT = "crx.default";

    public void createSession() throws RepositoryException {
        Repository repository = JcrUtils.getRepository("http://" + HOST + ":8080/crx/server");
        session = repository.login(
                new SimpleCredentials(USERNAME, PASSWORD.toCharArray()), CONTEXT);
    }

    public Node getNode(final String path) throws RepositoryException {
        return session.getNode(path);
    }
}
