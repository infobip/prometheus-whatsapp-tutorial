package com.infobip.alerting;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AlertsListener {

    private final InfobipWhatsAppClient whatsAppClient;

    AlertsListener(InfobipWhatsAppClient whatsAppClient) {
        this.whatsAppClient = whatsAppClient;
    }

    @PostMapping("/send-alert")
    void sendWhatsAppMessage(@RequestBody Alerts alerts) {
        alerts.alerts()
                .forEach(alert -> whatsAppClient.sendMessage(alert.text()));
    }
    
}
