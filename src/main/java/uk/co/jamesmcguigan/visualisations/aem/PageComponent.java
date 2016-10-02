package uk.co.jamesmcguigan.visualisations.aem;

import org.neo4j.ogm.annotation.Relationship;
import uk.co.jamesmcguigan.visualisations.infrastructure.Entity;

import java.util.HashSet;

public class PageComponent extends Entity {
    public PageComponent(){}

    public PageComponent(String name) {
        this.name = name;
    }

    //resourceType
    @Relationship(type= "INHERITS",direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> inherits = new HashSet<Component>();

}
