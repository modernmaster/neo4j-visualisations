package uk.co.jamesmcguigan.aem.visualisation.repository.impl;

import org.neo4j.ogm.service.Components;
import org.neo4j.ogm.session.Session;
import uk.co.jamesmcguigan.aem.visualisation.factory.Neo4JSessionFactory;
import uk.co.jamesmcguigan.aem.visualisation.repository.GraphRepository;
import uk.co.jamesmcguigan.aem.visualisation.repository.model.CrxNode;
import uk.co.jamesmcguigan.aem.visualisation.repository.model.Entity;

import java.util.HashMap;
import java.util.Map;

public class GraphRepositoryImpl implements GraphRepository {

    private static final int DEPTH_LIST = 0;
    private static final int DEPTH_ENTITY = 1;
    private Session session;


    public GraphRepositoryImpl() {
        Components.configuration()
                .driverConfiguration()
                .setDriverClassName("org.neo4j.ogm.drivers.http.driver.HttpDriver")
                .setURI("http://neo4j:admin@localhost:7474");
        session = Neo4JSessionFactory.getInstance().getNeo4jSession();
    }

    @Override
    public Iterable<CrxNode> findAll() {
        return session.loadAll(CrxNode.class, DEPTH_LIST);
    }

    @Override
    public CrxNode find(String name) {
        String query = String.format("Match(crx:CrxNode {name:\"%s\"})return crx",name);
        Map<String, Object> result = new HashMap<String, Object>();
        session.query(query, result);
        return null;
    }


    @Override
    public CrxNode find(Long id) {
        return session.load(CrxNode.class, id, DEPTH_ENTITY);
    }

    @Override
    public void delete(Long id) {
        session.delete(session.load(CrxNode.class, id));
    }

    @Override
    public Object createOrUpdate(Object entity) {
        session.save(entity, DEPTH_ENTITY);
        return find(((Entity) entity).getId());
    }
}
