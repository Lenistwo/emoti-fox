package pl.lenistwo.emotifox.exceptions;

public class ActorNotFoundException extends RuntimeException {
    public ActorNotFoundException() {
        super("User with given id not found");
    }

    public ActorNotFoundException(String message) {
        super(message);
    }
}
