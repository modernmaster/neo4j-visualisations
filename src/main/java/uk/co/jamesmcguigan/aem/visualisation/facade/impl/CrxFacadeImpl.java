package uk.co.jamesmcguigan.aem.visualisation.facade.impl;

import uk.co.jamesmcguigan.aem.visualisation.facade.CrxFacade;
import uk.co.jamesmcguigan.aem.visualisation.repository.CrxRepository;
import uk.co.jamesmcguigan.aem.visualisation.repository.GraphRepository;
import uk.co.jamesmcguigan.aem.visualisation.transformer.CrxNodeTransformer;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import java.util.LinkedList;
import java.util.Queue;

public class CrxFacadeImpl implements CrxFacade {

    private Queue<Node> nodeQueue;
    private CrxRepository crxRepository;
    private GraphRepository graphRepository;

    private String ROOT_PATH = "/content/moneysupermarket/en_gb/insurance/car-insurance/question-set/results";

    public CrxFacadeImpl(CrxRepository crxRepository, GraphRepository graphRepository) {
        this.crxRepository = crxRepository;
        this.nodeQueue = new LinkedList<Node>();
        this.graphRepository = graphRepository;
    }

    @Override
    public void createCrxRepresentation() throws RepositoryException {

        crxRepository.createSession();
        Node rootNode = crxRepository.getNode(ROOT_PATH);
        nodeQueue.add(rootNode);

        while(nodeQueue.peek()!=null) {
            Node currentNode = nodeQueue.remove();

            isPresentInGraph(currentNode);

            graphRepository.createOrUpdate(CrxNodeTransformer.toCrxNode(currentNode));
            NodeIterator nodeIterator = currentNode.getNodes();
            while(nodeIterator.hasNext()) {
                nodeQueue.add(nodeIterator.nextNode());
            }
        }
    }

    private void isPresentInGraph(Node node){
        graphRepository.find("aboutInsurerTitle");
    }








}
