package uk.co.jamesmcguigan.aem.visualisation.repository.impl;

import uk.co.jamesmcguigan.aem.visualisation.repository.model.Component;

public class ComponentRepositoryImpl extends EntityRepositoryImpl<Component> {

    @Override
    public Class<Component> getEntityType() {
        return Component.class;
    }
}
