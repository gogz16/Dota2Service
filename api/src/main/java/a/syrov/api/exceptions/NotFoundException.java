package a.syrov.api.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Object Not Found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
