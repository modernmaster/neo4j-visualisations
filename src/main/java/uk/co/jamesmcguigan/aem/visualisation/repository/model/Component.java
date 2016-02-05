package uk.co.jamesmcguigan.aem.visualisation.repository.model;


import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;

@NodeEntity()
public class Component extends Entity {

    public Component(){}

    public Component(String name) {
        this.name = name;
        isMemberOf = new HashSet<Component>();
    }

    //resourceSuperType
    @Relationship(type= "INHERITS",direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> isMemberOf = new HashSet<Component>();
}
