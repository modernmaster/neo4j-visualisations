package uk.co.jamesmcguigan.visualisations.aem.repository;

import uk.co.jamesmcguigan.visualisations.aem.PageComponent;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

public class PageComponentRepository extends AbstractEntityRepository<PageComponent> {

    @Override
    public Class<PageComponent> getEntityType() {
        return PageComponent.class;
    }
}
