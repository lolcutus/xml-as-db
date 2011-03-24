package ro.cuzma.larry.persistance.xml.samples.sample2.objectxmlconnection;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.XMLObject;
import ro.cuzma.larry.persistance.xml.XMLTagFactory;
import ro.cuzma.larry.persistance.xml.XMLTagValue;
import ro.cuzma.larry.persistance.xml.XMLTagValueList;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public class XMLFactoryLibrary implements XMLTagFactory {

    public XMLObject getHelper(String tagName) throws XMLException {
        if (tagName != null) {
            if (tagName.equals(XMLTags.PACKAGE)) {
                return new PackageHelper();
            } else if (tagName.equals(XMLTags.CALIBREBOOK)) {
                return new CalibreBookHelper();
            } else if (tagName.equals(XMLTags.CALIBREBOOK_META)) {
                XMLTagValueList<Entity<String>> xmlObj = new XMLTagValueList<Entity<String>>(
                        "metas", "meta");
                xmlObj.setShowMasterTag(false);
                return xmlObj;
            } else if (tagName.equals(XMLTags.CALIBREBOOK_AUTHOR)) {
                XMLTagValueList<Entity<String>> xmlObj = new XMLTagValueList<Entity<String>>(
                        XMLTags.CALIBREBOOK_AUTHOR, XMLTags.CALIBREBOOK_AUTHOR);
                xmlObj.setShowMasterTag(false);
                return xmlObj;
            } else {
                return new XMLTagValue(tagName);
            }
        } else {
            throw new XMLException("tagName must not be null");
        }
    }
}
