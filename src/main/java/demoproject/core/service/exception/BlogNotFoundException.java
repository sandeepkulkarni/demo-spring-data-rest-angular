package demoproject.core.service.exception;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
public class BlogNotFoundException extends RuntimeException {
    public BlogNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BlogNotFoundException(String message) {
        super(message);
    }

    public BlogNotFoundException() {
    }
}
