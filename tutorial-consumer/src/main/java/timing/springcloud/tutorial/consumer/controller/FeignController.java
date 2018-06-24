package timing.springcloud.tutorial.consumer.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import timing.springcloud.tutorial.consumer.feign.MyFeignClient;

@RestController
public class FeignController {

    @Autowired
    private MyFeignClient feignClient;

    @GetMapping(value = "/testFeign/{para}")
    @HystrixCommand(fallbackMethod = "fallback")
    public String testFeign(@PathVariable("para") String para) {
        String ret = feignClient.testFeign(para);
        System.out.println("feignresponse=" + ret);
        return ret;
    }

    @GetMapping(value = "/testHystrix/{para}")
    @HystrixCommand(fallbackMethod = "fallback")
    public String testHystrix(@PathVariable("para") String para) {
        String ret = feignClient.testHystrix(para);
        System.out.println("feignresponse=" + ret);
        return ret;
    }

    public String fallback(String para) {
        String temp = "testHystrix调用失败！参数为：" + para;
        System.out.println(temp);
        return temp;
    }
}
