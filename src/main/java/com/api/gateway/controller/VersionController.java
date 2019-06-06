package com.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/version")
public class VersionController {

    @RequestMapping(method = RequestMethod.GET)
    public String version() {
        return "version 0.1";
    }
}
