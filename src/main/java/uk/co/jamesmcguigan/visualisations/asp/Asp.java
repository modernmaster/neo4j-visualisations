package uk.co.jamesmcguigan.visualisations.asp;

import org.neo4j.ogm.annotation.Relationship;
import uk.co.jamesmcguigan.visualisations.aem.Component;
import uk.co.jamesmcguigan.visualisations.infrastructure.Entity;

import java.util.HashSet;

public class Asp extends Entity {

    public Asp() {
    }

    public Asp(String name) {
        this.name = name;
    }

    @Relationship(type= "INHERITS",direction = Relationship.UNDIRECTED)
    public java.util.Set<Asp> inherits = new HashSet<Asp>();

}

