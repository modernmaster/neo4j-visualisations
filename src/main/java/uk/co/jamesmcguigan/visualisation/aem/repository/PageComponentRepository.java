package uk.co.jamesmcguigan.visualisation.aem.repository;

import uk.co.jamesmcguigan.visualisation.aem.PageComponent;

public class PageComponentRepository extends EntityRepositoryImpl<PageComponent> {

    @Override
    public Class<PageComponent> getEntityType() {
        return PageComponent.class;
    }
}
