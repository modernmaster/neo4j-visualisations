package uk.co.jamesmcguigan.visualisations;

import javax.jcr.RepositoryException;

public interface VisualisationGenerator {

    public void create() throws RepositoryException;
}
