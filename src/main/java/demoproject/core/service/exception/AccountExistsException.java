package demoproject.core.service.exception;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public class AccountExistsException extends RuntimeException {
    public AccountExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountExistsException(String message) {
        super(message);
    }

    public AccountExistsException() {
        super();
    }
}
