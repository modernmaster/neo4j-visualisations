package uk.co.jamesmcguigan.visualisations.infrastructure;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class Neo4JSessionFactory {

    private final static SessionFactory sessionFactory = new SessionFactory("uk.co.jamesmcguigan.aem.visualisation");
    private static Neo4JSessionFactory factory = new Neo4JSessionFactory();

    public static Neo4JSessionFactory getInstance() {
        return factory;
    }

    private Neo4JSessionFactory() {
    }

    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}
