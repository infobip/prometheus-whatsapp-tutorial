package com.infobip.alerting;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AlertsListener {

    private final InfobipWhatsAppService whatsAppService;

    AlertsListener(InfobipWhatsAppService whatsAppService) {
        this.whatsAppService = whatsAppService;
    }

    @PostMapping("/send-alert")
    void sendWhatsAppMessage(@RequestBody Alerts alerts) {
        alerts.alerts()
                .forEach(alert -> whatsAppService.sendWhatsAppMessage(alert.asText()));
    }

}
