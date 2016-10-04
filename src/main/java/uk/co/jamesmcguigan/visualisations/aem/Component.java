package uk.co.jamesmcguigan.visualisations.aem;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import uk.co.jamesmcguigan.visualisations.infrastructure.Entity;

import java.util.HashSet;

@NodeEntity()
public class Component extends Entity {

    public Component() {
    }

    public Component(final String name) {
        this.name = name;
        isMemberOf = new HashSet<Component>();
    }

    //resourceSuperType
    @Relationship(type = "INHERITS", direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> isMemberOf = new HashSet<Component>();
}
