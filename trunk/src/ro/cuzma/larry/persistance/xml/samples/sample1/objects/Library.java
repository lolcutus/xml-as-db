/**
 * Copyright (c) Salomon Automation GmbH
 */
package ro.cuzma.larry.persistance.xml.samples.sample1.objects;

import ro.cuzma.larry.persistance.common.Entity;
import ro.cuzma.larry.persistance.common.EntityList;

public class Library extends Entity<String> {

    private String             name;
    private String             root;
    private EntityList<Author> authors = new EntityList<Author>();

    public Library(String name, String root) {
        this.name = name;
        this.root = root;
    }

    public Library() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthors(EntityList<Author> authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public EntityList<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

}
