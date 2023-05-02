package hm35.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
    public class Ping {
        @GetMapping("/ping")
        @ResponseBody
        public String ping() {
            return "OK";
        }
}
