package uk.co.jamesmcguigan.aem.visualisation.facade.impl;

import uk.co.jamesmcguigan.aem.visualisation.facade.CrxFacade;
import uk.co.jamesmcguigan.aem.visualisation.factory.EntityFactory;
import uk.co.jamesmcguigan.aem.visualisation.factory.EntityRespositoryFactory;
import uk.co.jamesmcguigan.aem.visualisation.repository.CrxRepository;
import uk.co.jamesmcguigan.aem.visualisation.repository.EntityRepository;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import java.util.LinkedList;
import java.util.Queue;

public class CrxFacadeImpl implements CrxFacade {

    private Queue<Node> nodeQueue;
    private CrxRepository crxRepository;
    private final static String CQ_TEMPLATE = "cq:template";
    private String ROOT_PATH = "/content/moneysupermarket/en_gb/insurance/car-insurance/question-set/results";
//private String ROOT_PATH = "/apps/";

    public CrxFacadeImpl(CrxRepository crxRepository) {
        this.crxRepository = crxRepository;
        this.nodeQueue = new LinkedList<Node>();
    }

    @Override
    public void createCrxRepresentation() throws RepositoryException {

        crxRepository.createSession();
        Node rootNode = crxRepository.getNode(ROOT_PATH);
        nodeQueue.add(rootNode);

        while(nodeQueue.peek()!=null) {
            Node currentNode = nodeQueue.remove();

            String primaryType = currentNode.getProperty(EntityFactory.JCR_PrimaryType).getString();
            String resourceType = "";
            try{
                currentNode.getProperty(EntityFactory.SLING_RESOURCE_TYPE).getString();
            }
            catch(PathNotFoundException ignore){

            }
            EntityRepository entityRepository = EntityRespositoryFactory.createEntityRepository(primaryType,resourceType);

            Object graphNode = entityRepository.find(currentNode.getName());
            if(graphNode == null){
                graphNode = entityRepository.createOrUpdate(EntityFactory.createEntity(currentNode));
            }

//            addResourceType(currentNode,graphNode);
//            this.entityRepository.createOrUpdate(graphNode);

            NodeIterator nodeIterator = currentNode.getNodes();
            while(nodeIterator.hasNext()) {
                nodeQueue.add(nodeIterator.nextNode());
            }
        }
    }

//    private void addResourceType(Node jcrNode, Component graphNode) {
//        try {
//            Property property = jcrNode.getProperty(JCR_PRIMARYTYPE);
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
