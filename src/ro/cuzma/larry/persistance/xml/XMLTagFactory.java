package ro.cuzma.larry.persistance.xml;

import ro.cuzma.larry.persistance.xml.exception.XMLException;

public interface XMLTagFactory {

    public XMLObject getHelper(String tagName) throws XMLException;
}
