package uk.co.jamesmcguigan.visualisations.aem.repository;

import uk.co.jamesmcguigan.visualisations.aem.Page;

public class PageRespository extends EntityRepositoryImpl<Page> {

    @Override
    public Class<Page> getEntityType() {
        return Page.class;
    }
}
