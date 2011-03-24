package ro.cuzma.larry.persistance.xml;

import java.util.HashMap;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public abstract class XMLObject {
    private String                  tag;
    private HashMap<String, String> atributes = new HashMap<String, String>();

    public HashMap<String, String> getAtributes() {
        return atributes;
    }

    public void setAtributes(HashMap<String, String> atributes) {
        this.atributes = atributes;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public XMLObject(String tag) {
        this.tag = tag;
    }

    public abstract boolean toSave();

    public XMLObject(String tag, Entity<?> entity) throws XMLException {
        this.tag = tag;
        initWithEntity(entity);
    }

    public void addAtribute(String name, String value) {
        atributes.put(name, value);
    }

    public String getAtribute(String name) {
        return atributes.get(name);

    }

    protected abstract void initWithEntity(Entity<?> entity) throws XMLException;

    protected abstract String toXml(String indent) throws XMLException;
}
