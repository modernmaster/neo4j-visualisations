package uk.co.jamesmcguigan.aem.visualisation.repository.impl;

import org.neo4j.ogm.service.Components;
import org.neo4j.ogm.session.Session;
import uk.co.jamesmcguigan.aem.visualisation.factory.Neo4JSessionFactory;
import uk.co.jamesmcguigan.aem.visualisation.repository.EntityRepository;
import uk.co.jamesmcguigan.aem.visualisation.repository.model.Entity;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class EntityRepositoryImpl<T> implements EntityRepository<T> {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
    private Session session;


    public EntityRepositoryImpl() {
        Components.configuration()
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .setURI("http://neo4j:admin@localhost:7474");
        session = Neo4JSessionFactory.getInstance().getNeo4jSession();
    }

    @Override
    public T find(String name) {
        try{
        String query = String.format("Match(n:Component {name:\"%s\"})return n",name);
        Map<String, Object> result = new HashMap<String, Object>();
        Iterator<T> n = session.query(getEntityType(),  query, Collections.EMPTY_MAP).iterator();
        return n.next();
        }
        catch(Exception ex){
            return null;
        }
    }

    @Override
    public T find(Long id) {
        return session.load(getEntityType(), id, DEPTH_ENTITY);
    }

    @Override
    public T createOrUpdate(Entity entity) {
        session.save(entity, DEPTH_ENTITY);
        return find(entity.getId());
    }

    public abstract Class<T> getEntityType();
}
