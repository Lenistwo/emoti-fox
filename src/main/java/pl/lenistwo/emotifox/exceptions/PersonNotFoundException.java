package pl.lenistwo.emotifox.exceptions;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException() {
        super("User with given id not found");
    }

    public PersonNotFoundException(String message) {
        super(message);
    }
}
