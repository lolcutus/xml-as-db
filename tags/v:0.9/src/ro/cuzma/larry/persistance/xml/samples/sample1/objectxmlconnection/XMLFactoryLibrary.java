package ro.cuzma.larry.persistance.xml.samples.sample1.objectxmlconnection;

import ro.cuzma.larry.persistance.xml.XMLObject;
import ro.cuzma.larry.persistance.xml.XMLTagFactory;
import ro.cuzma.larry.persistance.xml.exception.XMLException;

public class XMLFactoryLibrary implements XMLTagFactory {

    public XMLObject getHelper(String tagName) throws XMLException {
        if (tagName != null) {
            if (tagName.equals(XMLTags.LIBRARY)) {
                return new LibraryHelper();
            } else if (tagName.equals(XMLTags.AUTHOR)) {
                return new AuthorHelper();
            } else {
                throw new XMLException("No type defined for tag: <" + tagName + ">.");
            }
        } else {
            throw new XMLException("tagName must not be null");
        }
    }
}
