package com.klu.model;

public class ErrorResponse {

    private String timestamp;
    private String message;
    private int statusCode;

    public ErrorResponse(String timestamp, String message, int statusCode) {
        this.timestamp = timestamp;
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }
}