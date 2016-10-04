package uk.co.jamesmcguigan.visualisations.infrastructure;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

public class Neo4JSessionFactory {

    private static final SessionFactory SESSION_FACTORY = new SessionFactory("uk.co.jamesmcguigan.visualisations");
    private static Neo4JSessionFactory factory = new Neo4JSessionFactory();

    public static Neo4JSessionFactory getInstance() {
        return factory;
    }

    private Neo4JSessionFactory() {
    }

    public Session getNeo4jSession() {
        return SESSION_FACTORY.openSession();
    }
}
