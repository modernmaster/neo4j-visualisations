package uk.co.jamesmcguigan.visualisations.aem.repository;

import org.apache.jackrabbit.commons.JcrUtils;

import javax.jcr.*;

public class ContentRepositoryImpl implements ContentRepository {

    private Session session;
    private final static String HOST = "2674-w7e";
    private final static String USERNAME = "admin";
    private final static String PASSWORD = "admin";
    private final static String CONTEXT = "crx.default";

    public void createSession() throws RepositoryException {
        Repository repository = JcrUtils.getRepository("http://" + HOST + ":8080/crx/server");
        session = repository.login(
                new SimpleCredentials(USERNAME, PASSWORD.toCharArray()),CONTEXT);
    }

    public Node getNode(String path) throws RepositoryException {
        return session.getNode(path);
    }
}
