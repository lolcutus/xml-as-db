package ro.cuzma.larry.persistance.xml;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.common.EntityIdAndValue;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public class XMLSimpleIdValue extends XMLNode {
    private XMLTagValue id;
    private XMLTagValue valueTag;

    public XMLSimpleIdValue(String tag) {
        super(tag);
    }

    public XMLSimpleIdValue(String tag, Entity<?> entity) throws XMLException {
        super(tag, entity);
    }

    public XMLTagValue getId() {
        return id;
    }

    public XMLTagValue getValueTag() {
        return valueTag;
    }

    protected void initTags() {
        id = new XMLTagValue(XMLTags.SIMPLEIDVALUE_ID, null);
        valueTag = new XMLTagValue(XMLTags.SIMPLEIDVALUE_VALUE, null);
        xmlObjects.add(id);
        xmlObjects.add(valueTag);

    }

    @Override
    protected void initWithEntity(Entity<?> entity) {
        EntityIdAndValue<?> obj = (EntityIdAndValue<?>) entity;
        id.setValue(obj.getId().toString());
        valueTag.setValue(obj.getValue());

    }
}
