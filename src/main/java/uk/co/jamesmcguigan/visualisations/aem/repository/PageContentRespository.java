package uk.co.jamesmcguigan.visualisations.aem.repository;

import uk.co.jamesmcguigan.visualisations.aem.PageContent;

public class PageContentRespository extends EntityRepositoryImpl<PageContent> {
    @Override
    public Class<PageContent> getEntityType() {
        return PageContent.class;
    }
}
