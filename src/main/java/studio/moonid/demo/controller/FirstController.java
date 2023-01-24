package studio.moonid.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Controller for RestAPI
public class FirstController {

    @GetMapping("/api/hello")
    public String hello() {
        return "hello world!";
    }
}