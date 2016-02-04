package uk.co.jamesmcguigan.aem.visualisation.transformer;

import uk.co.jamesmcguigan.aem.visualisation.repository.model.CrxNode;

import javax.jcr.Node;

public class CrxNodeTransformer {

    public static CrxNode toCrxNode(Node node){
        try {
            CrxNode crxNode = new CrxNode(node.getName());
            return crxNode;
        } catch (Exception ex)
        {
            return null;
        }
    }

}
