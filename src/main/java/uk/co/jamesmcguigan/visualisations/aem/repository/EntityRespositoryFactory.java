package uk.co.jamesmcguigan.visualisations.aem.repository;

import uk.co.jamesmcguigan.visualisations.aem.EntityFactory;
import uk.co.jamesmcguigan.visualisations.infrastructure.EntityRepository;

public class EntityRespositoryFactory {

    private static EntityRepository pageRepository = new PageRespository();
    private static EntityRepository pageContentRepository = new PageContentRespository();
    private static EntityRepository pageComponentRepository = new PageComponentRepository();
    private static EntityRepository componentRepository = new ComponentRepository();

    public static EntityRepository createEntityRepository(String primaryType, String resourceType){

        if(primaryType.equals(EntityFactory.CQ_PAGE)){
            return pageRepository;

        }else if(primaryType.equals(EntityFactory.CQ_PAGE_CONTENT)){
            return pageContentRepository;

        }else if(primaryType.equals(EntityFactory.NT_UNSTRUCTURED)){
            if(resourceType!=null   ){
                return pageComponentRepository;
            }
        }
        return componentRepository;
    }
}
