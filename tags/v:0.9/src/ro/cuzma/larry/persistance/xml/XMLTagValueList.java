package ro.cuzma.larry.persistance.xml;

import java.util.ArrayList;
import java.util.List;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public class XMLTagValueList<E extends Entity<?>> extends XMLObject {
    List<XMLTagValue> tagValueList  = new ArrayList<XMLTagValue>();
    private String    childrenTag;
    private boolean   showMasterTag = true;

    public boolean isShowMasterTag() {
        return showMasterTag;
    }

    public void setShowMasterTag(boolean showMasterTag) {
        this.showMasterTag = showMasterTag;
    }

    public List<XMLTagValue> getData() {
        return tagValueList;
    }

    public void setNodeList(List<XMLTagValue> nodeList) {
        this.tagValueList = nodeList;
    }

    public XMLTagValueList(String tag, String childrenTag) {
        super(tag);
        this.childrenTag = childrenTag;
    }

    public String toXml(String indent) throws XMLException {
        String xml = "";
        if (toSave()) {
            if (showMasterTag) {
                indent += "\t";
                xml = XMLUtil.getStartTag(this, indent,
                        (tagValueList != null && tagValueList.size() > 0));
            }
            for (XMLTagValue pair : this.getData()) {
                xml += pair.toXml(indent);
            }
            if (showMasterTag) {
                xml += XMLUtil.getEndTagNewLine(this.getTag(), indent);
            }
        }
        return xml;
    }

    public void add(XMLTagValue tagValue) {
        tagValueList.add(tagValue);
    }

    public String getChildrenTag() {
        return childrenTag;
    }

    @Override
    public boolean toSave() {
        return (tagValueList != null && tagValueList.size() > 0) || getAtributes().size() > 0;
    }

    @Override
    protected void initWithEntity(Entity<?> entity) throws XMLException {
        throw new XMLException("Not supose to be here!!! implementit in your class :).");
    }

}
