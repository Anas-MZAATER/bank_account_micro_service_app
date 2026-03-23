package net.anas.customerservice.web;

import net.anas.customerservice.config.GlobalConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConfigTestController {
    @Value("${global.params.a:0}")
    private int a;
    @Value("${global.params.b:0}")
    private int b;
    @Value("${customer.params.x:0}")
    private int x;
    @Value("${customer.params.y:0}")
    private int y;

    @GetMapping("/testConfig")
    public Map<String, Integer> configTest() {
        return Map.of("a",a,"b",b,"x",x,"y",y);
    }

    @Autowired
    private GlobalConfig globalConfig;

    @GetMapping("/globalConfig")
    public GlobalConfig getGlobalConfig() {
        return globalConfig;
    }
}
