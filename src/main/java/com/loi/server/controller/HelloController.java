package com.loi.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${spring.application.name:ZookeeperExampleApp}")
    private String appName;

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private Environment env;

    @Autowired(required = false)
    private Registration registration;

    @RequestMapping("/")
    public ServiceInstance lb() {
        return this.loadBalancer.choose(this.appName);
    }

    @RequestMapping("/myenv")
    public String env(@RequestParam("prop") String prop) {
        return this.env.getProperty(prop, "Not Found");
    }

    @GetMapping("/hello/{who}")
    public String hello(@PathVariable("who") String who) {
        return String.format("Hello: %s! from %s", who, this.registration.getHost());
    }
}
