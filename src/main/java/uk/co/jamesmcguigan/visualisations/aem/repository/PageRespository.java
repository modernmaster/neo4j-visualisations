package uk.co.jamesmcguigan.visualisations.aem.repository;

import uk.co.jamesmcguigan.visualisations.aem.Page;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

public class PageRespository extends AbstractEntityRepository<Page> {

    @Override
    public Class<Page> getEntityType() {
        return Page.class;
    }
}
