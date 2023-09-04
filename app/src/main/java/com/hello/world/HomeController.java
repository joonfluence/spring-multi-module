package com.hello.world;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    private final Integer serverPort;

    public HomeController(@Value("${server.port}") final int serverNumber) {
        this.serverPort = serverNumber;
    }

    @GetMapping("/")
    public Integer count(){
        return serverPort;
    }
}
