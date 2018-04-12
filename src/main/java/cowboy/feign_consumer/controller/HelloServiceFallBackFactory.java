package cowboy.feign_consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cowboy.feign_consumer.bo.User;
import cowboy.feign_consumer.ws.HelloFeignService;
import feign.hystrix.FallbackFactory;

/**
 * 服务降级写法
 * @author ydzcowboy
 *
 */
@Component
public class HelloServiceFallBackFactory implements FallbackFactory<HelloFeignService>{
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloServiceFallBackFactory.class);
	@Override
	public HelloFeignService create(Throwable arg0) {
		HelloServiceFallBackFactory.LOGGER.info("fallback; reason was:", arg0);
		return new HelloFeignService(){

			@Override
			public String hello() {
				// TODO Auto-generated method stub
				return "error";
			}

			@Override
			public String hello(String name) {
				// TODO Auto-generated method stub
				return "error";
			}

			@Override
			public String HelloById(Integer id) {
				// TODO Auto-generated method stub
				return "error";
			}

			@Override
			public User hello(String name, Integer age) {
				// TODO Auto-generated method stub
				return new User("未知",0);
			}

			@Override
			public String hello(User user) {
				// TODO Auto-generated method stub
				return "error";
			}

			@Override
			public User getUserByName(String name) {
				// TODO Auto-generated method stub
				return new User("未知",0);
			}
			
		}; 
	}

}
