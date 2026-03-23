package net.anas.customerservice.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConfigTestController {
    @Value("${global.params.a:0}")
    private int a;
    @Value("${global.params.b:0}")
    private int b;
    @Value("${customer.params.x:0}")
    private int x;
    @Value("${customer.params.y:0}")
    private int y;

    @GetMapping("/config-test")
    public Map<String, Integer> configTest() {
        return Map.of("a",a,"b",b,"x",x,"y",y);
    }
}
