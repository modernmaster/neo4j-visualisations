package uk.co.jamesmcguigan.aem.visualisation.repository.model;

import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;

public class PageComponent extends PageContent {
    public PageComponent(){}

    public PageComponent(String name) {
        this.name = name;
    }

    //resourceType
    @Relationship(type= "INHERITS",direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> inherits = new HashSet<Component>();

}
