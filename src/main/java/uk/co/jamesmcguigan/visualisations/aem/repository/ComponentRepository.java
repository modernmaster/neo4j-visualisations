package uk.co.jamesmcguigan.visualisations.aem.repository;

import uk.co.jamesmcguigan.visualisations.aem.Component;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

public class ComponentRepository extends AbstractEntityRepository<Component> {

    @Override
    public Class<Component> getEntityType() {
        return Component.class;
    }
}
