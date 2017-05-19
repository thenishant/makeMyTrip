package exception;

public class NoPaymentModeFoundException extends Exception {

    public NoPaymentModeFoundException(String message, Throwable cause) {
        super(message,cause);
    }

    public NoPaymentModeFoundException(String message) {
        super(message);
    }
}
