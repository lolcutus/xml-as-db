/**
 * Copyright (c) Salomon Automation GmbH
 */
package ro.cuzma.larry.persistance.xml.samples.sample1.objects;

import ro.cuzma.larry.persistance.common.EntityIdAndValue;
import ro.cuzma.larry.persistance.xml.XMLSimpleIdValue;
import ro.cuzma.larry.persistance.xml.samples.sample1.objectxmlconnection.AuthorHelper;
import ro.cuzma.larry.persistance.xml.samples.sample1.objectxmlconnection.LibraryHelper;

public class EntityFactory {

    public static EntityIdAndValue buildSimpleIdValue(XMLSimpleIdValue obj) {
        EntityIdAndValue retObj = new EntityIdAndValue();
        retObj.setId(obj.getId().getValue());
        retObj.setValue(obj.getValueTag().getValue());
        return retObj;

    }

    public static Author buildAuthor(AuthorHelper ah) {
        Author author = new Author();
        author.setId(new Long(ah.getId()));
        author.setName(ah.getName().getValue());
        author.setFirstName(ah.getFirstName().getValue());
        author.setMiddleName(ah.getMiddleName().getValue());
        return author;

    }

    public static Library buildLibrary(LibraryHelper lh) {
        Library library = new Library();
        library.setName(lh.getName().getValue());
        library.setRoot(lh.getRoot().getValue());
        // Authors
        for (AuthorHelper ah : lh.getAuthors().getData()) {
            library.addAuthor(buildAuthor(ah));
        }
        // Books
        // List<Book> books = new ArrayList<Book>();
        return library;
    }
}
