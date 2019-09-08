package timing.springcloud.tutorial.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RefreshScope
public class HelloController {

    @Value("${provider.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello "+name+"，this is first messge";
    }

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/service")
    @ResponseBody
    public String test(HttpServletResponse response, String para) {
        return para + "_service";
    }

    @GetMapping("/feignservice/{para}")
    @ResponseBody
    public String feignservice(HttpServletResponse response, @PathVariable String para) {
        return para + "_service";
    }



    @RequestMapping("/provider")
    public String from() {
        return this.hello;
    }
}
