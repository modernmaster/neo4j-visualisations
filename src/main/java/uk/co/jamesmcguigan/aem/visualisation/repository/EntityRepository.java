package uk.co.jamesmcguigan.aem.visualisation.repository;

import uk.co.jamesmcguigan.aem.visualisation.repository.model.Entity;

public interface EntityRepository<T> {

    T find(Long id);
    T find(String name);
    T createOrUpdate(Entity entity);
}
