package ro.cuzma.larry.persistance.xml.samples.sample1.objectxmlconnection;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.xml.XMLNode;
import ro.cuzma.larry.persistance.xml.XMLTagValue;
import ro.cuzma.larry.persistance.xml.exception.XMLException;
import ro.cuzma.larry.persistance.xml.samples.sample1.objects.Author;

public class AuthorHelper extends XMLNode {

    private XMLTagValue id;
    private XMLTagValue name;
    private XMLTagValue firstName;
    private XMLTagValue middleName;

    public AuthorHelper(Author author) throws XMLException {
        super(XMLTags.AUTHOR, author);
    }

    public AuthorHelper() {
        super(XMLTags.AUTHOR);
    }

    @Override
    protected void initTags() {
        id = new XMLTagValue(XMLTags.AUTHOR_ID, null);
        name = new XMLTagValue(XMLTags.AUTHOR_NAME, null);
        firstName = new XMLTagValue(XMLTags.AUTHOR_FIRSTNAME, null);
        middleName = new XMLTagValue(XMLTags.AUTHOR_MIDDLENAME, null);
        xmlObjects.add(id);
        xmlObjects.add(name);
        xmlObjects.add(firstName);
        xmlObjects.add(middleName);

    }

    @Override
    protected void initWithEntity(Entity<?> entity) {
        Author author = (Author) entity;
        id.setValue(author.getId().toString());
        name.setValue(author.getName());
        firstName.setValue(author.getFirstName());
        middleName.setValue(author.getMiddleName());

    }

    public XMLTagValue getId() {
        return id;
    }

    public XMLTagValue getName() {
        return name;
    }

    public XMLTagValue getFirstName() {
        return firstName;
    }

    public XMLTagValue getMiddleName() {
        return middleName;
    }

}
