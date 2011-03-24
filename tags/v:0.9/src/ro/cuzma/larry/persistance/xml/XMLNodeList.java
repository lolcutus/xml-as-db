package ro.cuzma.larry.persistance.xml;

import java.util.ArrayList;
import java.util.List;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public class XMLNodeList<T extends XMLNode, E extends Entity<?>> extends XMLObject {
    List<T>        nodeList = new ArrayList<T>();
    private String childrenTag;

    public List<T> getData() {
        return nodeList;
    }

    public void setNodeList(List<T> nodeList) {
        this.nodeList = nodeList;
    }

    public XMLNodeList(String tag, String childrenTag) {
        super(tag);
        this.childrenTag = childrenTag;
    }

    public void add(T node) {
        nodeList.add(node);
    }

    public String getChildrenTag() {
        return childrenTag;
    }

    public String toXml(String indent) throws XMLException {
        String xml = "";
        if (toSave()) {
            xml = XMLUtil.getStartTag(this, indent, (nodeList != null && nodeList.size() > 0));

            for (XMLNode pair : this.getData()) {
                xml += pair.toXml(indent + "\t");
            }
            xml += XMLUtil.getEndTagNewLine(this.getTag(), indent);
        }
        return xml;
    }

    @Override
    public boolean toSave() {
        return (nodeList != null && nodeList.size() > 0) || getAtributes().size() > 0;
    }

    @Override
    protected void initWithEntity(Entity<?> entity) throws XMLException {
        throw new XMLException("Not supose to be here!!! implementit in your class :).");

    }
}
