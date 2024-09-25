package com.infobip.alerting;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("infobip.whatsapp")
class InfobipProperties {

    private String baseUrl;
    private String apiKey;
    private String sender;
    private String receiver;

    InfobipProperties() {
    }

    InfobipProperties(String baseUrl, String apiKey, String sender, String receiver) {
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.sender = sender;
        this.receiver = receiver;
    }

    String getBaseUrl() {
        return baseUrl;
    }

    void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    String getApiKey() {
        return apiKey;
    }

    void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    String getSender() {
        return sender;
    }

    void setSender(String sender) {
        this.sender = sender;
    }

    String getReceiver() {
        return receiver;
    }

    void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}


