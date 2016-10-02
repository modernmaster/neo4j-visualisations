package uk.co.jamesmcguigan.visualisation.aem.repository;

import uk.co.jamesmcguigan.visualisation.aem.PageContent;

public class PageContentRespository extends EntityRepositoryImpl<PageContent> {
    @Override
    public Class<PageContent> getEntityType() {
        return PageContent.class;
    }
}
