package uk.co.jamesmcguigan.aem.visualisation.repository;

import uk.co.jamesmcguigan.aem.visualisation.repository.model.CrxNode;

public interface GraphRepository<CrxNode>{

    Iterable<CrxNode> findAll();
    CrxNode find(Long id);
    void delete(Long id);
    CrxNode createOrUpdate(CrxNode entity);

    uk.co.jamesmcguigan.aem.visualisation.repository.model.CrxNode find(String name);
}
