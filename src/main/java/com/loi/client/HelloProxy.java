package com.loi.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ZookeeperExampleApp")
interface HelloProxy {
    @GetMapping(path = "/hello/{who}")
    String hello(@PathVariable("who") String who);
}