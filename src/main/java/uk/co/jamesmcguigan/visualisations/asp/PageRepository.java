package uk.co.jamesmcguigan.visualisations.asp;

import uk.co.jamesmcguigan.visualisations.aem.Component;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

public class PageRepository extends AbstractEntityRepository<Asp> {

    @Override
    public Class<Asp> getEntityType() {
        return Asp.class;
    }
}
