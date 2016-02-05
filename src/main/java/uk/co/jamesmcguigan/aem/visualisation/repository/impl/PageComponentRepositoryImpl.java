package uk.co.jamesmcguigan.aem.visualisation.repository.impl;

import uk.co.jamesmcguigan.aem.visualisation.repository.model.PageComponent;

public class PageComponentRepositoryImpl extends EntityRepositoryImpl<PageComponent> {

    @Override
    public Class<PageComponent> getEntityType() {
        return PageComponent.class;
    }
}
