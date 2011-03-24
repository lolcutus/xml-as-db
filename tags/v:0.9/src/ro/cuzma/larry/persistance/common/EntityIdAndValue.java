package ro.cuzma.larry.persistance.common;

public class EntityIdAndValue<T> extends Entity<T> {

    private String value;

    public EntityIdAndValue(T id, String display) {
        this.id = id;
        this.value = display;
    }

    public EntityIdAndValue() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
