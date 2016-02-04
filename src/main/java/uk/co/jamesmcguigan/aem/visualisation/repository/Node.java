package uk.co.jamesmcguigan.aem.visualisation.repository;

import org.neo4j.graphdb.Direction;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.HashSet;

@NodeEntity
public class Node {

//    @GraphId
//    Long id;
//    public String name;
//
//    public Person() {}
//    public Person(String name) { this.name = name; }
//
//    @RelatedTo(type="TEAMMATE", direction= Direction.BOTH)
//    public @Fetch
//    java.util.Set<Node> teammates;
//
//    public void worksWith(Node person) {
//        if (teammates == null) {
//            teammates = new HashSet<Node>();
//        }
//        teammates.add(person);
//    }
//
//    public String toString() {
//        String results = name + "'s teammates include\n";
//        if (teammates != null) {
//            for (Node person : teammates) {
//                results += "\t- " + person.name + "\n";
//            }
//        }
//        return results;
//    }

}
