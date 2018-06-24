package timing.springcloud.tutorial.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-service", configuration = BasicAuthConfiguration.class,  fallbackFactory = HystrixClientFallbackFactory.class)
public interface MyFeignClient {
 
	/**
	 * 隐射到rest-service
	 * @param para
	 * @return
	 */
    @GetMapping(value = "/feignservice/{para}")
    String testFeign(@PathVariable("para") String para);
    
    @GetMapping(value = "/testHystrix/{para}")
    String testHystrix(@PathVariable("para") String para);
 
}
