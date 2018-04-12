package cowboy.feign_consumer.ws;

import org.springframework.cloud.netflix.feign.FeignClient;

import cowboy.hello_service_api.service.HelloService;

@FeignClient(name="eureka-client")
public interface HelloFeignService4Api extends HelloService{

}
