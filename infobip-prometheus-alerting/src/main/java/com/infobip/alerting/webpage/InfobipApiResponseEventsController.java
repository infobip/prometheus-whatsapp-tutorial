package com.infobip.alerting.webpage;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
public class InfobipApiResponseEventsController {
    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();

    @GetMapping("/ib-sse")
    public SseEmitter registerServerSideEventReceiver() {
        SseEmitter emitter = new SseEmitter(0L);
        emitters.add(emitter);
        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        return emitter;
    }

    public void notify(String eventData) {
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(eventData);
            } catch (Exception e) {
                emitters.remove(emitter);
            }
        }
    }
}
