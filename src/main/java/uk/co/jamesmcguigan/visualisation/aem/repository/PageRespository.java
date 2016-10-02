package uk.co.jamesmcguigan.visualisation.aem.repository;

import uk.co.jamesmcguigan.visualisation.aem.Page;

public class PageRespository extends EntityRepositoryImpl<Page> {

    @Override
    public Class<Page> getEntityType() {
        return Page.class;
    }
}
