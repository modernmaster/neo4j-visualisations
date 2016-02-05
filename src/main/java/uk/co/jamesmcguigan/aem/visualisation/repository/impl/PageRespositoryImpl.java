package uk.co.jamesmcguigan.aem.visualisation.repository.impl;

import uk.co.jamesmcguigan.aem.visualisation.repository.model.Page;

public class PageRespositoryImpl extends EntityRepositoryImpl<Page> {

    @Override
    public Class<Page> getEntityType() {
        return Page.class;
    }
}
