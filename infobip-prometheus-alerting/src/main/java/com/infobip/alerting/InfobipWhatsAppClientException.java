package com.infobip.alerting;

public class InfobipWhatsAppClientException extends RuntimeException {

    public InfobipWhatsAppClientException(String message) {
        super(message);
    }

    public InfobipWhatsAppClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
