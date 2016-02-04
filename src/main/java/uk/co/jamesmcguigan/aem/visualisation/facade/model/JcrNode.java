package uk.co.jamesmcguigan.aem.visualisation.facade.model;

import java.util.ArrayList;

public class JcrNode {

    private String name;
    private String type;
    private String path;
    private ArrayList<JcrProperty> properties;
    private ArrayList<JcrNode> children;

//    public JcrNode (String name, String path){
//        this.name = name;
//        //this.type = type;
//        this.path = path;
//    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<JcrProperty> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<JcrProperty> properties) {
        this.properties = properties;
    }

    public ArrayList<JcrNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<JcrNode> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
