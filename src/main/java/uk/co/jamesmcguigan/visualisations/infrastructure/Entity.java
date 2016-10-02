package uk.co.jamesmcguigan.visualisations.infrastructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.Relationship;
import uk.co.jamesmcguigan.visualisations.aem.Component;

import java.util.HashSet;

public abstract class Entity {

    @JsonProperty("id")
    protected Long id;
    @JsonProperty("name")
    public String name;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Relationship(type= "TYPEOF",direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> resourceType = new HashSet<Component>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || id == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (!id.equals(entity.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (id == null) ? -1 : id.hashCode();
    }
}
