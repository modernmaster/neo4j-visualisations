package uk.co.jamesmcguigan.visualisations.aem;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.jamesmcguigan.visualisations.VisualisationGenerator;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;
import uk.co.jamesmcguigan.visualisations.aem.repository.ContentRepository;
import uk.co.jamesmcguigan.visualisations.aem.repository.EntityRespositoryFactory;
import uk.co.jamesmcguigan.visualisations.infrastructure.Entity;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.Property;
import javax.jcr.RepositoryException;
import java.util.LinkedList;
import java.util.Queue;

public class AEMVisualationGenerator implements VisualisationGenerator {

    public static final String UNABLE_TO_ADD_RESOURCE_TYPE = "Unable to add resource type";
    public static final String EMPTY_STRING = "";
    private static final Logger LOGGER = LoggerFactory.getLogger(AEMVisualationGenerator.class);
    private static final String UNABLE_TO_ACCESS_REPOSITORY = "Unable to access repository";
    private static final String UNABLE_TO_ACCESS_ROOT_PATH = "Unable to access root path";
    private static final String CQ_TEMPLATE = "cq:template";
    private static final String ROOT_PATH = "/content/moneysupermarket/en_gb/insurance/car-insurance/question-set/results";
    private Queue<Node> nodeQueue;
    private ContentRepository contentRepository;
//private String ROOT_PATH = "/apps/";

    public AEMVisualationGenerator(final ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
        this.nodeQueue = new LinkedList<Node>();
    }

    public void create() {

        Node rootNode = getRootNode();
        nodeQueue.add(rootNode);

        while (nodeQueue.peek() != null) {
            Node currentNode = nodeQueue.remove();
            try {
                AbstractEntityRepository entityRepository = createEntityRepository(currentNode);
                Entity entity = addCurrentNode(currentNode, entityRepository);
                addResourceType(currentNode, entity, entityRepository);
//                addTemplate(Node jcrNode, Component graphNode)

                NodeIterator nodeIterator = currentNode.getNodes();
                while (nodeIterator.hasNext()) {
                    nodeQueue.add(nodeIterator.nextNode());
                }
            } catch (RepositoryException e) {
                LOGGER.error(UNABLE_TO_ACCESS_REPOSITORY, e);
            }
        }
    }

    private Entity addCurrentNode(final Node currentNode, final AbstractEntityRepository entityRepository) throws RepositoryException {
        Entity entity = entityRepository.find(currentNode.getName());
        if (entity == null) {
            entity = (Entity) entityRepository.createOrUpdate(EntityFactory.createEntity(currentNode));
        }
        return entity;
    }

    private Node getRootNode() {
        try {
            contentRepository.createSession();
            return contentRepository.getNode(ROOT_PATH);
        } catch (RepositoryException e) {
            LOGGER.error(UNABLE_TO_ACCESS_ROOT_PATH, e);
        }
        return null;
    }

    private AbstractEntityRepository createEntityRepository(final Node currentNode) throws RepositoryException {
        String primaryType = currentNode.getProperty(EntityFactory.JCR_PRIMARY_TYPE).getString();
        String resourceType;
        if (!currentNode.hasProperty(EntityFactory.SLING_RESOURCE_TYPE)) {
            return EntityRespositoryFactory.createEntityRepository(primaryType, EMPTY_STRING);
        }
        resourceType = currentNode.getProperty(EntityFactory.SLING_RESOURCE_TYPE).getString();
        return EntityRespositoryFactory.createEntityRepository(primaryType, resourceType);
    }

    private void addResourceType(final Node currentNode, final Entity graphNode, final AbstractEntityRepository entityRepository) {
        try {
            if (!currentNode.hasProperty(EntityFactory.SLING_RESOURCE_TYPE)) {
                return;
            }
            AbstractEntityRepository componentRepository = EntityRespositoryFactory.createEntityRepository(EntityFactory.NT_UNSTRUCTURED, "");
            Property property = currentNode.getProperty(EntityFactory.SLING_RESOURCE_TYPE);
            Component resourceType = (Component) componentRepository.find(property.getString());
            if (resourceType == null) {
                resourceType = (Component) componentRepository.createOrUpdate(new Component(property.getString()));
            }
            graphNode.resourceType.add(resourceType);
            entityRepository.createOrUpdate(graphNode);
        } catch (RepositoryException e) {
            LOGGER.error(UNABLE_TO_ADD_RESOURCE_TYPE, e);
        }
    }

    private void addTemplate(final Node currentNode, final PageContent graphNode, final AbstractEntityRepository entityRepository) {
        try {
            if (!currentNode.hasProperty(CQ_TEMPLATE)) {
                return;
            }
            AbstractEntityRepository componentRepository = EntityRespositoryFactory.createEntityRepository(EntityFactory.NT_UNSTRUCTURED, "");
            Property property = currentNode.getProperty(EntityFactory.SLING_RESOURCE_TYPE);
            Component resourceType = (Component) componentRepository.find(property.getString());
            if (resourceType == null) {
                resourceType = (Component) componentRepository.createOrUpdate(new Component(property.getString()));
            }
            graphNode.isTemplateOf.add(resourceType);
            entityRepository.createOrUpdate(graphNode);
        } catch (RepositoryException e) {
            LOGGER.error(UNABLE_TO_ADD_RESOURCE_TYPE, e);
        }
//        try {
//            Property property = jcrNode.getProperty(CQ_TEMPLATE);
//            Component resourceType = entityRepository.find(property.getString());
//            graphNode.templateOf.add(resourceType);
//        } catch (RepositoryException e) {
//            e.printStackTrace();
//            return;
//        }
    }

}
