package uk.co.jamesmcguigan.visualisations.aem.repository;

import org.apache.commons.lang3.StringUtils;
import uk.co.jamesmcguigan.visualisations.aem.EntityFactory;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

public class EntityRespositoryFactory {

    private static PageRespository pageRepository = new PageRespository();
    private static PageContentRespository pageContentRepository = new PageContentRespository();
    private static PageComponentRepository pageComponentRepository = new PageComponentRepository();
    private static ComponentRepository componentRepository = new ComponentRepository();

    private EntityRespositoryFactory() {
    }

    public static AbstractEntityRepository createEntityRepository(final String primaryType, final String resourceType) {
        if (primaryType.equals(EntityFactory.CQ_PAGE)) {
            return pageRepository;

        } else if (primaryType.equals(EntityFactory.CQ_PAGE_CONTENT)) {
            return pageContentRepository;

        } else if (primaryType.equals(EntityFactory.NT_UNSTRUCTURED)) {
            if (!StringUtils.isEmpty(resourceType)) {
                return pageComponentRepository;
            }
        }
        return componentRepository;
    }
}
