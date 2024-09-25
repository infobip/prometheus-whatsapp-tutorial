package com.infobip.alerting;

import java.util.List;
import java.util.Map;

record Alerts(List<Alert> alerts) {

    record Alert(String status, Map<String, Object> labels, Map<String, Object> annotations) {

        String asText() {
            var severity = (String) labels.get("severity");
            var instance = (String) labels.get("instance");
            var summary = (String) annotations.get("summary");
            return """
                    %s!
                    The alert for instance running on '%s' is %s
                    %s
                    """.formatted(severity, instance, status, summary).replace("\n", "\\n");
        }

    }

}
