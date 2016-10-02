package uk.co.jamesmcguigan.visualisations.aem;


import uk.co.jamesmcguigan.visualisations.VisualisationGenerator;
import uk.co.jamesmcguigan.visualisations.aem.repository.EntityRespositoryFactory;
import uk.co.jamesmcguigan.visualisations.aem.repository.ContentRepository;
import uk.co.jamesmcguigan.visualisations.aem.repository.PageRespository;
import uk.co.jamesmcguigan.visualisations.infrastructure.EntityRepository;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import java.util.LinkedList;
import java.util.Queue;

public class AEMVisualationGenerator implements VisualisationGenerator {

    private Queue<Node> nodeQueue;
    private ContentRepository contentRepository;
    private final static String CQ_TEMPLATE = "cq:template";
    private String ROOT_PATH = "/content/moneysupermarket/en_gb/insurance/car-insurance/question-set/results";
//private String ROOT_PATH = "/apps/";

    public AEMVisualationGenerator(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
        this.nodeQueue = new LinkedList<Node>();
    }

    public void create() throws RepositoryException {

        contentRepository.createSession();
        Node rootNode = contentRepository.getNode(ROOT_PATH);
        nodeQueue.add(rootNode);

        while(nodeQueue.peek()!=null) {
            Node currentNode = nodeQueue.remove();

            String primaryType = currentNode.getProperty(EntityFactory.JCR_PRIMARY_TYPE).getString();
            String resourceType = "";
//            String resourceType = currentNode.getProperty(EntityFactory.SLING_RESOURCE_TYPE).getString();;
//            try{
//
//            }
//            catch(PathNotFoundException ignore){
//
//            }
//            EntityRepository<Page> entityRepository = EntityRespositoryFactory.createEntityRepository(primaryType,resourceType);


            PageRespository pageRespository = new PageRespository();


            Page graphNode = pageRespository.find(currentNode.getName());
            if(graphNode == null){
                graphNode = pageRespository.createOrUpdate(EntityFactory.createEntity(currentNode));
            }

            //addResourceType(currentNode,graphNode);

            NodeIterator nodeIterator = currentNode.getNodes();
            while(nodeIterator.hasNext()) {
                nodeQueue.add(nodeIterator.nextNode());
            }
        }
    }

//    private void addResourceType(Node jcrNode, Component graphNode) {
//        try {
//            Property property = jcrNode.getProperty(EntityFactory.JCR_PRIMARY_TYPE);
//            Component resourceType = entityRepository.find(property.getString());
//            if(resourceType==null){
//                resourceType = entityRepository.createOrUpdate(new Component(property.getString()));
//            }
//            graphNode.resourceType.add(resourceType);
//            entityRepository.createOrUpdate(graphNode);
//
//        } catch (RepositoryException e) {
//            e.printStackTrace();
//            return;
//        }
//    }

//    private void addTemplate(Node jcrNode, Component graphNode) {
//        try {
//            Property property = jcrNode.getProperty(CQ_TEMPLATE);
//            Component resourceType = entityRepository.find(property.getString());
//            graphNode.templateOf.add(resourceType);
//        } catch (RepositoryException e) {
//            e.printStackTrace();
//            return;
//        }
//    }

}
