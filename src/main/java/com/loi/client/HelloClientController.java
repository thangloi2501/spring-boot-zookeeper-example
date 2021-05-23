package com.loi.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
public class HelloClientController {

    @Autowired
    private HelloProxy helloProxy;

    @GetMapping("/hello/{who}")
    public String hello(@PathVariable("who") String who) {
        return helloProxy.hello(who);
    }
}
