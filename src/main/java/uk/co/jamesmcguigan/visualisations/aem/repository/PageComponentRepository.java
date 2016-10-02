package uk.co.jamesmcguigan.visualisations.aem.repository;

import uk.co.jamesmcguigan.visualisations.aem.PageComponent;

public class PageComponentRepository extends EntityRepositoryImpl<PageComponent> {

    @Override
    public Class<PageComponent> getEntityType() {
        return PageComponent.class;
    }
}
