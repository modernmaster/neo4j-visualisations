package uk.co.jamesmcguigan.aem.visualisation.repository.model;

import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;

public class PageContent extends Entity {

    public PageContent(){}

    public PageContent(String name) {
        this.name = name;
    }

    //template
    @Relationship(type= "ISTEMPLATEOF",direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> isTemplateOf = new HashSet<Component>();

    //resourceType
    @Relationship(type= "INHERITS",direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> inherits = new HashSet<Component>();

}
