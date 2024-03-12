package com.pucpr.exemplo;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {
    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World!";
    }
    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("/param")
    public String helloParam(@RequestParam String name) {
        return "Param, " + name + "!";
    }

    @GetMapping("/get_parameters")
    public String getParameters(@RequestParam("start") String param1,
                                @RequestParam("end") String param2) {
        return param1 + "Param22, " + param2 + "!";
    }
}
