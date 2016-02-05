package uk.co.jamesmcguigan.aem.visualisation.factory;

import uk.co.jamesmcguigan.aem.visualisation.repository.EntityRepository;
import uk.co.jamesmcguigan.aem.visualisation.repository.impl.*;

public class EntityRespositoryFactory {

    private static EntityRepository pageRepository = new PageRespositoryImpl();
    private static EntityRepository pageContentRepository = new PageContentRespositoryImpl();
    private static EntityRepository pageComponentRepository = new PageComponentRepositoryImpl();
    private static EntityRepository componentRepository = new ComponentRepositoryImpl();

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
