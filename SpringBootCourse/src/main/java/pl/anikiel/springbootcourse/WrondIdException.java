package pl.anikiel.springbootcourse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WrondIdException extends RuntimeException {
    public WrondIdException(String s) {
        super(s);
    }
}