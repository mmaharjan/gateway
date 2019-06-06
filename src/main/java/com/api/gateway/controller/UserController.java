package com.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/user")
public class UserController {

    @RequestMapping(method = RequestMethod.POST)
    public String getUser() {
        return "returning user info";
    }
}
