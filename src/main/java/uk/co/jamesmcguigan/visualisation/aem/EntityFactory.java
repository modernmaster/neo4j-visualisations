package uk.co.jamesmcguigan.visualisation.aem;

import uk.co.jamesmcguigan.visualisation.infrastructure.Entity;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

public class EntityFactory {

    public final static String CQ_PAGE_CONTENT = "cq:PageContent";
    public final static String CQ_PAGE = "cq:Page";
    public final static String SLING_RESOURCE_TYPE = "sling:resourceType";
    public final static String JCR_PRIMARY_TYPE = "jcr:primaryType";
    public final static String NT_UNSTRUCTURED = "nt:unstructured";

    public static Entity createEntity(Node node) {

        String resourceType = "";
        try {
            resourceType = node.getProperty(SLING_RESOURCE_TYPE).getString();
        } catch (PathNotFoundException ignored) {
        } catch (ValueFormatException e) {
            e.printStackTrace();
        } catch (RepositoryException e) {
            e.printStackTrace();
        }

        try {
            String primaryType = node.getProperty(JCR_PRIMARY_TYPE).getString();
            if (primaryType.equals(CQ_PAGE)) {
                return new Page(node.getName());

            } else if (primaryType.equals(CQ_PAGE_CONTENT)) {
                return new PageContent(node.getName());

            } else if (primaryType.equals(NT_UNSTRUCTURED)) {
                if (resourceType != null) {
                    return new PageComponent(node.getName());
                }
                return new Component(node.getName());
            }
        } catch (Exception ignored) {

        }
        return null;
    }
}
