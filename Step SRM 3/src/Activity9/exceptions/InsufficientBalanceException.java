package Activity9.exceptions;

public class InsufficientBalanceException extends AccountException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
