package uk.co.jamesmcguigan.aem.visualisation.repository;

import org.junit.Before;
import org.junit.Test;
import org.neo4j.graphdb.GraphDatabaseService;
import uk.co.jamesmcguigan.aem.visualisation.repository.impl.GraphRepositoryImpl;
import uk.co.jamesmcguigan.aem.visualisation.repository.model.CrxNode;

public class GraphRepositoryTests {

    private String DB_PATH = "C:\\Users\\james.mcguigan\\Documents\\Neo4j\\default.graphdb";
    private GraphRepository crxNodeGraphRepository;

    @Before
    public void setup() {
        crxNodeGraphRepository = new GraphRepositoryImpl();
    }

    @Test
    public void shouldDoSomething() {

        CrxNode crx = new CrxNode("test");
        GraphRepository crxNodeGraphRepository = new GraphRepositoryImpl();
        crxNodeGraphRepository.createOrUpdate(crx);
    }

//    @Before
//    public void setup() {
//        embeddedGraphDatabaseService = new GraphDatabaseFactory().newEmbeddedDatabase(DB_PATH);
//        registerShutdownHook(embeddedGraphDatabaseService);
//    }
//
//    private static void registerShutdownHook( final GraphDatabaseService graphDb )
//    {
//        // Registers a shutdown hook for the Neo4j instance so that it
//        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
//        // running application).
//        Runtime.getRuntime().addShutdownHook( new Thread()
//        {
//            @Override
//            public void run()
//            {
//                graphDb.shutdown();
//            }
//        } );
//    }
//
//    @Test
//    public void testAddNodeToGraph() {
//        Transaction tx = embeddedGraphDatabaseService.beginTx();
//        try {
//            Node firstNode = embeddedGraphDatabaseService.createNode();
//            firstNode.setProperty("message", "Hello, ");
//            Node secondNode = embeddedGraphDatabaseService.createNode();
//            secondNode.setProperty( "message", "World!" );
//        Relationship relationship = firstNode.createRelationshipTo( secondNode, CrxRelationshipType.INSTANCEOF);
//        relationship.setProperty( "message", "brave Neo4j " );
//
//        System.out.print( firstNode.getProperty( "message" ) );
//        System.out.print( relationship.getProperty( "message" ) );
//        System.out.print( secondNode.getProperty( "message" ) );
//        }
//        finally {
//            tx.terminate();
//            tx.close();
//        }
//    }

}
