package uk.co.jamesmcguigan.aem.visualisation.facade.model;

public class JcrProperty {
    public String name;
    public int type;
    public String value;
    public Boolean multiField;

    JcrProperty(String name, int type, String value) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.multiField = false;
    }

    JcrProperty(String name, int type, String value, Boolean multiField) {
        this.name = name;
        this.type = type;
        this.value = value;
        this.multiField = multiField;
    }

    public String [] toMultipleFieldValue(){
        return  value.split("\n");
    }
}
