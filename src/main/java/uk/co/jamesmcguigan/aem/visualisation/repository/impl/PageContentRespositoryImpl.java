package uk.co.jamesmcguigan.aem.visualisation.repository.impl;

import uk.co.jamesmcguigan.aem.visualisation.repository.model.PageContent;

public class PageContentRespositoryImpl extends EntityRepositoryImpl<PageContent> {
    @Override
    public Class<PageContent> getEntityType() {
        return PageContent.class;
    }
}
