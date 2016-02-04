package uk.co.jamesmcguigan.aem.visualisation.repository.model;


import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Property;

@NodeEntity
public class CrxNode extends Entity {

    @Property
    private String name;

    public CrxNode(String name) {
        this.name = name;
    }

    @Relationship(type= "INHERITS",direction = Relationship.UNDIRECTED)
    private java.util.Set<CrxNode> superType;

    @Relationship(type= "INSTANCESOF",direction = Relationship.UNDIRECTED)
    private java.util.Set<CrxNode> instancesOf;

}
