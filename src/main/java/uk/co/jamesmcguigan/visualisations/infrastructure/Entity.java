package uk.co.jamesmcguigan.visualisations.infrastructure;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.Relationship;
import uk.co.jamesmcguigan.visualisations.aem.Component;

import java.util.HashSet;

public abstract class Entity {

    @JsonProperty("name")
    public String name;
    @Relationship(type = "TYPEOF", direction = Relationship.UNDIRECTED)
    public java.util.Set<Component> resourceType = new HashSet<Component>();
    @JsonProperty("id")
    protected Long id;

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || id == null || getClass() != o.getClass()) {
            return false;
        }
        Entity entity = (Entity) o;
        if (!id.equals(entity.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return -1;
        }
        return id.hashCode();
    }
}
