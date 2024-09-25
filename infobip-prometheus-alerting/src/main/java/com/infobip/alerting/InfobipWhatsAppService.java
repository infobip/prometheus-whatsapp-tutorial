package com.infobip.alerting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
class InfobipWhatsAppService {

    private final Logger log = LoggerFactory.getLogger(InfobipWhatsAppService.class);
    private final HttpClient client = HttpClient.newHttpClient();

    private final String baseUrl;
    private final String apiKey;
    private final String sender;
    private final String receiver;

    InfobipWhatsAppService(InfobipProperties properties) {
        this.baseUrl = properties.getBaseUrl();
        this.apiKey = properties.getApiKey();
        this.sender = properties.getSender();
        this.receiver = properties.getReceiver();
    }

    void sendWhatsAppMessage(String message) {
        var request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .header("Authorization", apiKey)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(createPayload(message)))
                .build();

        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("Response: {}", response.body());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String createPayload(String message) {
        return """
                {
                    "from": "%s",
                    "to": "%s",
                    "content": {
                        "text" : "%s"
                    }
                }""".formatted(sender, receiver, message);
    }
}

