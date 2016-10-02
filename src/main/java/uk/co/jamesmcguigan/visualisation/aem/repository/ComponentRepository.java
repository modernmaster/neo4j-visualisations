package uk.co.jamesmcguigan.visualisation.aem.repository;

import uk.co.jamesmcguigan.visualisation.aem.Component;

public class ComponentRepository extends EntityRepositoryImpl<Component> {

    @Override
    public Class<Component> getEntityType() {
        return Component.class;
    }
}
