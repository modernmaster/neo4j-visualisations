package uk.co.jamesmcguigan.visualisations.aem.repository;

import uk.co.jamesmcguigan.visualisations.aem.PageContent;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

public class PageContentRespository extends AbstractEntityRepository<PageContent> {
    @Override
    public Class<PageContent> getEntityType() {
        return PageContent.class;
    }
}
