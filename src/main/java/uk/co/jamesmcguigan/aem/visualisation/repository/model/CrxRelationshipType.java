package uk.co.jamesmcguigan.aem.visualisation.repository.model;

import org.neo4j.graphdb.RelationshipType;

public enum CrxRelationshipType implements RelationshipType {
    INHERITS, INSTANCEOF
}
