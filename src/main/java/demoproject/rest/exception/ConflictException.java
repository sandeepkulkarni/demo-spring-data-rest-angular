package demoproject.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by sandeep kulkarni on 7/5/2015.
 */
@ResponseStatus(value= HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {
    public ConflictException() {
    }

    public ConflictException(Throwable cause) {
        super(cause);
    }
}
