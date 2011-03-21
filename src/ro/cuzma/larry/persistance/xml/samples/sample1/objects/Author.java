package ro.cuzma.larry.persistance.xml.samples.sample1.objects;

import ro.cuzma.larry.persistance.common.Entity;

public class Author extends Entity<Long> {

    private String firstName;
    private String middleName;
    private String name;

    public Author(Long id, String firstName, String middleName, String name) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.name = name;
    }

    public Author() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getElementValue() {
        return id.toString();
    }

}
