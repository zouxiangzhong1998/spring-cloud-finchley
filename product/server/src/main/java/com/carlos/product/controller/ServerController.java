package com.carlos.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 18:40
 */
@RestController
public class ServerController {

    @GetMapping("msg")
    public String msg() {
        return "this is product msg";
    }

}
