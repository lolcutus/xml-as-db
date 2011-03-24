package ro.cuzma.larry.persistance.xml;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public class XMLNodeWithID extends XMLNode {
    protected final static String id = "id";

    public XMLNodeWithID(String tag) {
        super(tag);

    }

    public XMLNodeWithID(String tag, Entity<?> entity) throws XMLException {
        super(tag, entity);
    }

    public String getId() {
        return getAtribute(id);
    }

    @Override
    protected void initTags() {
        this.addAtribute(id, null);
    }

    @Override
    protected void initWithEntity(Entity<?> entity) throws XMLException {
    }

}
