package ro.cuzma.larry.persistance.common.exceptions;

public class EntityException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public EntityException() {
    }

    public EntityException(String arg0) {
        super(arg0);
    }

    public EntityException(Throwable arg0) {
        super(arg0);
    }

    public EntityException(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

}
