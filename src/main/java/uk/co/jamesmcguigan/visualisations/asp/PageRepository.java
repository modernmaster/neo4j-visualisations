package uk.co.jamesmcguigan.visualisations.asp;

import uk.co.jamesmcguigan.visualisations.aem.Component;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

public class PageRepository extends AbstractEntityRepository<Component> {

    @Override
    public Class<Component> getEntityType() {
        return Component.class;
    }
}
