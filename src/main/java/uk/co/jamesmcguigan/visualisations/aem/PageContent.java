package uk.co.jamesmcguigan.visualisations.aem;

import org.neo4j.ogm.annotation.Relationship;
import uk.co.jamesmcguigan.visualisations.infrastructure.Entity;

import java.util.HashSet;

public class PageContent extends Entity {

    public PageContent(){}

    public PageContent(String name) {
        this.name = name;
    }

    @Relationship(type= "ISTEMPLATEOF",direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> isTemplateOf = new HashSet<Component>();

    @Relationship(type= "INHERITS",direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> inherits = new HashSet<Component>();

}
