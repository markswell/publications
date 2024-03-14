package com.markswell.publications.exception;

public class PublicationNotFoundException extends RuntimeException {

    public PublicationNotFoundException(String message) {
        super(message);
    }
}
