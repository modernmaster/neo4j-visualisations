package uk.co.jamesmcguigan.visualisations.aem;

import uk.co.jamesmcguigan.visualisations.infrastructure.Entity;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

public class EntityFactory {

    public static final String CQ_PAGE_CONTENT = "cq:PageContent";
    public static final String CQ_PAGE = "cq:Page";
    public static final String SLING_RESOURCE_TYPE = "sling:resourceType";
    public static final String JCR_PRIMARY_TYPE = "jcr:primaryType";
    public static final String NT_UNSTRUCTURED = "nt:unstructured";

    private EntityFactory() {}

    public static Entity createEntity(final Node node) {

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
                if (resourceType == null) {
                    return new PageComponent(node.getName());
                }
                return new Component(node.getName());
            }
        } catch (Exception ignored) {

        }
        return null;
    }
}
