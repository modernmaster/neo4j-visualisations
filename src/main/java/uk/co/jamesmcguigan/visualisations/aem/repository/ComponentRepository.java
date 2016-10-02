package uk.co.jamesmcguigan.visualisations.aem.repository;

import uk.co.jamesmcguigan.visualisations.aem.Component;

public class ComponentRepository extends EntityRepositoryImpl<Component> {

    @Override
    public Class<Component> getEntityType() {
        return Component.class;
    }
}
