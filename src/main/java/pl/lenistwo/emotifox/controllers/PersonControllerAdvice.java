package pl.lenistwo.emotifox.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.lenistwo.emotifox.exceptions.PersonNotFoundException;

@CrossOrigin("*")
@ControllerAdvice
public class PersonControllerAdvice {

    @ResponseBody
    @ExceptionHandler({PersonNotFoundException.class})
    public Error handlePersonNotFoundException(Exception e) {
        return new Error(404, e.getMessage());
    }

}

@AllArgsConstructor
class Error {
    private int statusCode;
    private String message;
}
