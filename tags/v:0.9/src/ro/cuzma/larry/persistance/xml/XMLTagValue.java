package ro.cuzma.larry.persistance.xml;

import java.util.GregorianCalendar;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public class XMLTagValue extends XMLObject {

    private String value;

    public void setValue(String value) {
        this.value = value;
    }

    public XMLTagValue(String tag, String value) {
        super(tag);
        this.value = value;
    }

    public XMLTagValue(String tag) {
        super(tag);
    }

    public String getValue() {
        return value;
    }

    private String toXml(XMLTagValue pair, String indent) throws XMLException {
        String xml = "";
        if (this.toSave()) {
            Object value = pair.getValue();
            String name = pair.getTag();
            xml += XMLUtil.getStartTag(pair, indent, value != null);
            if (value != null) {
                if (value instanceof String) {
                    xml += (String) value + XMLUtil.getEndTag(name);
                } else if (value instanceof Long) {
                    xml += ((Long) value).toString() + XMLUtil.getEndTag(name);
                } else {
                    throw new XMLException("not know to save type");
                }
            }
        }
        return xml;

    }

    public String toXml(String indent) throws XMLException {
        return toXml(this, indent);
    }

    @Override
    public boolean toSave() {
        return (value != null && value.toString() != null && !value.toString().equals(""))
                || getAtributes().size() > 0;
    }

    @Override
    protected void initWithEntity(Entity<?> entity) {
        value = entity.toString();

    }

    public Long getLong() {
        return new Long(value);
    }

    public GregorianCalendar getDate() {
        return XMLUtil.convertGregorianCalendar(value, null);
    }
}
