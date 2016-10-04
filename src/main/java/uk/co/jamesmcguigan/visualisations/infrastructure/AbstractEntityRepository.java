package uk.co.jamesmcguigan.visualisations.infrastructure;

import org.neo4j.ogm.service.Components;
import org.neo4j.ogm.session.Session;

import java.util.Collections;
import java.util.Iterator;

public abstract class AbstractEntityRepository<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
    private Session session;


    public AbstractEntityRepository() {
        Components.configuration()
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .setURI("http://neo4j:admin@localhost:7474");
        session = Neo4JSessionFactory.getInstance().getNeo4jSession();
    }

    public Entity find(final String name) {
        try {
            String query = String.format("Match(n:%s {name:\"%s\"})return n", getEntityType().getSimpleName(), name);
            Iterator<Entity> n = session.query(getEntityType(), query, Collections.EMPTY_MAP).iterator();
            return n.next();
        } catch (Exception ex) {
            return null;
        }
    }

    public T find(final Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY);
    }

    public T createOrUpdate(final Entity entity) {
        session.save(entity, DEPTH_ENTITY);
        return find(entity.getId());
    }

    public abstract Class<T> getEntityType();
}
