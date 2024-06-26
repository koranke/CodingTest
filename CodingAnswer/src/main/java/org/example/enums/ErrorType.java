package org.example.enums;

public enum ErrorType {
    MinValueError("Unable to decrement sellIn.  Reached min value.")
    ;

    private final String message;

    ErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
