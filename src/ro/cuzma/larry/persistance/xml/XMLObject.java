package ro.cuzma.larry.persistance.xml;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public abstract class XMLObject {
    private String tag;

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

    protected abstract void initWithEntity(Entity<?> entity) throws XMLException;
}
