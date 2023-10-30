package de.berlin.webtech.gaestebuch.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloWorldController {

    // Parameterübergabe in URL-Pfad:
    @GetMapping(path = "/test/{userid}/username/{username}")
    public String index(@PathVariable int userid, @PathVariable String username) {
        return "Greetings from WebTech: " + userid + "! Your username is: " + username + "!";
    }

    // Parameterübergabe in URL als Paramter (trennen mit & in URL):
    @GetMapping(path = "/user")
    public String index2(@RequestParam int userid, @RequestParam String username) {
        return "Greetings from WebTech: " + userid + "! Your username is: " + username + "!";
    }

    // Hello World Test:
    @GetMapping(path = "/")
    public ModelAndView showHelloWorldPage() {
        return new ModelAndView("helloworld");
    }
}
