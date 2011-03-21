package ro.cuzma.larry.persistance.xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ro.cuzma.larry.persistance.xml.exception.XMLException;

public class XMLFileManipulation {

    XMLTagFactory xmlFactory;

    public XMLObject loadFromFile(File fileFrom, XMLTagFactory xmlFactory) throws XMLException {
        this.xmlFactory = xmlFactory;
        if (this.xmlFactory == null) {
            throw new XMLException("Need to define an XMLTagFactory.");
        }
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(fileFrom);
            NodeList nodeLst = doc.getElementsByTagName(doc.getDocumentElement().getNodeName());
            return proccessNodeList(nodeLst.item(0));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private XMLObject proccessNodeList(Node fstNode) throws XMLException {

        XMLObject xmlObj = xmlFactory.getHelper(fstNode.getNodeName());
        if (fstNode.getNodeType() == Node.ELEMENT_NODE) {
            if (xmlObj instanceof XMLNode) {
                proccessXMLNode(fstNode, (XMLNode) xmlObj);
            } else if (xmlObj instanceof XMLTagValue) {
                proccessXMLTagValue(fstNode, (XMLTagValue) xmlObj);

            }

        }
        return xmlObj;

    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private XMLObject proccessXMLNode(Node fstNode, XMLNode xmlNode) throws XMLException {

        for (XMLObject xmlElement : xmlNode.getData()) {
            if (xmlElement instanceof XMLTagValue) {
                List<Element> tagValueList = getChildrenByTagName((Element) fstNode,
                        xmlElement.getTag());
                if (tagValueList.size() > 0) {
                    proccessXMLTagValue(tagValueList.get(0), (XMLTagValue) xmlElement);
                }
            } else if (xmlElement instanceof XMLNode) {
                List<Element> nodeList = getChildrenByTagName((Element) fstNode,
                        xmlElement.getTag());
                Element nodeElement = nodeList.get(0);
                XMLNode node = (XMLNode) xmlElement;
                proccessXMLNode(nodeElement, (XMLNode) node);
            } else if (xmlElement instanceof XMLNodeList) {

                XMLNodeList xmlNodeList = (XMLNodeList) xmlElement;
                Element fstElmnt = (Element) fstNode;
                List<Element> tagList = getChildrenByTagName(fstElmnt, xmlNodeList.getTag());
                if (tagList.size() > 0) {
                    List<Element> childrenList = getChildrenByTagName(tagList.get(0),
                            xmlNodeList.getChildrenTag());
                    XMLObject xmlObj;
                    for (int i = 0; i < childrenList.size(); i++) {
                        xmlObj = xmlFactory.getHelper(xmlNodeList.getChildrenTag());
                        xmlNodeList.add((XMLNode) proccessXMLNode(childrenList.get(i),
                                (XMLNode) xmlObj));
                    }
                }

            } else if (xmlElement instanceof XMLTagValueList) {
                XMLTagValueList xmlTagValueList = (XMLTagValueList) xmlElement;
                List<Element> tagList = getChildrenByTagName((Element) fstNode,
                        xmlTagValueList.getTag());
                if (tagList.size() > 0) {
                    List<Element> childrenList = getChildrenByTagName((Element) tagList.get(0),
                            xmlTagValueList.getChildrenTag());
                    XMLObject xmlObj;
                    for (int i = 0; i < childrenList.size(); i++) {
                        xmlObj = xmlFactory.getHelper(xmlTagValueList.getChildrenTag());
                        xmlTagValueList.add(proccessXMLTagValue(childrenList.get(i),
                                (XMLTagValue) xmlObj));
                    }
                }
            }

        }
        return xmlNode;
    }

    private XMLTagValue proccessXMLTagValue(Node fstNode, XMLTagValue xmlTagValue) {
        String value;
        value = fstNode.getChildNodes().item(0).getNodeValue();
        xmlTagValue.setValue(value);
        return xmlTagValue;
    }

    public static List<Element> getChildrenByTagName(Element parent, String name) {
        List<Element> nodeList = new ArrayList<Element>();
        for (Node child = parent.getFirstChild(); child != null; child = child.getNextSibling()) {
            if (child.getNodeType() == Node.ELEMENT_NODE && name.equals(child.getNodeName())) {
                nodeList.add((Element) child);
            }
        }

        return nodeList;
    }
}
