package demoproject.core.service.exception;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public class AccountDoesNotExistException extends RuntimeException {
    public AccountDoesNotExistException(Throwable cause) {
        super(cause);
    }

    public AccountDoesNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public AccountDoesNotExistException(String message) {
        super(message);
    }

    public AccountDoesNotExistException() {
    }
}
