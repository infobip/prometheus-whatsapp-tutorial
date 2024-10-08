package com.infobip.alerting.webpage;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@DependsOn("infobipApiResponseEventsController")
public class HomepageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
