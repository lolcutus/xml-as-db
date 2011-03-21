package ro.cuzma.larry.persistance.xml;

import java.util.ArrayList;
import java.util.List;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public abstract class XMLNode extends XMLObject {
    protected List<XMLObject> xmlObjects = new ArrayList<XMLObject>();

    public XMLNode(String tag) {
        super(tag);
        initTags();
    }

    public XMLNode(String tag, Entity<?> entity) throws XMLException {
        super(tag);
        initTags();
        initWithEntity(entity);
    }

    protected abstract void initTags();

    public List<XMLObject> getData() {
        return xmlObjects;
    }

    public void setData(List<XMLObject> list) {
        this.xmlObjects = list;
    }

    public String toXml(String indent) {
        if (this.toSave()) {
            return toXml(this, indent);
        }
        return "";
    }

    @SuppressWarnings("rawtypes")
    private String toXml(XMLNode xmlNode, String indent) {
        String xml;
        xml = XMLUtil.getStartTag(xmlNode.getTag(), indent);

        for (XMLObject pair : xmlNode.getData()) {
            if (pair instanceof XMLTagValue) {
                xml += ((XMLTagValue) pair).toXml(indent + "\t");
            } else if (pair instanceof XMLNode) {
                xml += ((XMLNode) pair).toXml(indent + "\t");
            } else if (pair instanceof XMLNodeList) {
                xml += ((XMLNodeList) pair).toXml(indent + "\t");
            } else if (pair instanceof XMLTagValueList) {
                xml += ((XMLTagValueList) pair).toXml(indent + "\t");
            }
        }
        xml += XMLUtil.getEndTagNewLine(xmlNode.getTag(), indent);
        return xml;
    }

    @Override
    public boolean toSave() {
        return xmlObjects != null && xmlObjects.size() > 0;
    }

}
