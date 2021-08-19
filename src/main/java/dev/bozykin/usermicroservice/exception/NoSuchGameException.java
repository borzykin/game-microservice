package dev.bozykin.usermicroservice.exception;

public class NoSuchGameException extends Exception {
    public NoSuchGameException(String message) {
        super(message);
    }
}
