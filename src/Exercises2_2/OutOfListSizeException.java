package Exercises2_2;

public class OutOfListSizeException extends Exception {
    private String message = "";

    public OutOfListSizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return "OutOfListSizeException: " + message;
    }

    @Override
    public String toString() {
        return "OutOfListSizeException: " + message;
    }
}
