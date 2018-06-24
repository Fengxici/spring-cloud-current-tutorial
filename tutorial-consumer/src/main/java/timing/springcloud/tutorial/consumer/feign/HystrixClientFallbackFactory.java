package timing.springcloud.tutorial.consumer.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<MyFeignClient> {
	@Override
	public MyFeignClient create(Throwable cause) {
		return new MyFeignClient() {

			@Override
			public String testFeign(String para) {
				cause.printStackTrace();
				return cause.getMessage();
			}

			@Override
			public String testHystrix(String para) {
				cause.printStackTrace();
				return cause.getMessage();
			}
		};
	}
}
