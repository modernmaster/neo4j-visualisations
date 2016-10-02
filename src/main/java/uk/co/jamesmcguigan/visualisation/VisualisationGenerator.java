package uk.co.jamesmcguigan.visualisation;

import javax.jcr.RepositoryException;

public interface VisualisationGenerator {

    public void create() throws RepositoryException;
}
