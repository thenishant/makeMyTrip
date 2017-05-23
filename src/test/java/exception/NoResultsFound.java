package exception;

public class NoResultsFound extends Exception {

    public NoResultsFound(String message, Throwable cause) {
        super(message,cause);
    }

    public NoResultsFound(String message) {
        super(message);
    }
}