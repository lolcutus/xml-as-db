package ro.cuzma.larry.persistance.xml.samples.sample1.objectxmlconnection;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.XMLNode;
import ro.cuzma.larry.persistance.xml.XMLNodeList;
import ro.cuzma.larry.persistance.xml.XMLTagValue;
import ro.cuzma.larry.persistance.xml.exception.XMLException;
import ro.cuzma.larry.persistance.xml.samples.sample1.objects.Author;
import ro.cuzma.larry.persistance.xml.samples.sample1.objects.Library;

public class LibraryHelper extends XMLNode {

    private XMLTagValue                       name;
    private XMLTagValue                       root;
    private XMLNodeList<AuthorHelper, Author> authors;

    public LibraryHelper() {
        super(XMLTags.LIBRARY);
    }

    public LibraryHelper(Library library) throws XMLException {
        super(XMLTags.LIBRARY, library);
    }

    public XMLTagValue getName() {
        return name;
    }

    public XMLTagValue getRoot() {
        return root;
    }

    public XMLNodeList<AuthorHelper, Author> getAuthors() {
        return authors;
    }

    private void setAuthorList(Library library) throws XMLException {
        AuthorHelper autH;
        for (Author author : library.getAuthors().getEntityList()) {
            autH = new AuthorHelper(author);
            authors.add(autH);
        }
    }

    protected void initTags() {
        name = new XMLTagValue(XMLTags.LIBRARY_NAME, null);
        root = new XMLTagValue(XMLTags.LIBRARY_ROOT, null);
        authors = new XMLNodeList<AuthorHelper, Author>(XMLTags.LIBRARY_AUTHORS, XMLTags.AUTHOR);
        xmlObjects.add(root);
        xmlObjects.add(name);
        xmlObjects.add(authors);
    }

    @Override
    protected void initWithEntity(Entity<?> entity) throws XMLException {
        Library library = (Library) entity;
        if (library != null) {
            name.setValue(library.getName());
            root.setValue(library.getRoot());
            setAuthorList(library);
        }
    }

}
