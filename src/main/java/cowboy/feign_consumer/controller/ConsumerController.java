package cowboy.feign_consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cowboy.feign_consumer.ws.HelloFeignService;
import cowboy.feign_consumer.ws.HelloFeignService4Api;

@RestController
public class ConsumerController {

	@Autowired
	HelloFeignService helloService;
	
	@Autowired
	HelloFeignService4Api helloFeignService4Api;
	
	@RequestMapping(value="/feign-consumer",method=RequestMethod.GET)
	String helloConsumer(){
		System.out.println("feign consumer say hello");
		return helloService.hello();
	}
	
	@RequestMapping(value="/feign-consumer2",method=RequestMethod.GET)
	String helloConsumer2(){
		StringBuilder sb = new StringBuilder();
		sb.append(helloService.hello()).append("\n");
		sb.append(helloService.hello("cowboy")).append("\n");
		sb.append(helloService.hello(new cowboy.feign_consumer.bo.User("cowboy",13))).append("\n");
		sb.append(helloService.HelloById(14)).append("\n");
		sb.append(helloService.hello("cowboy", 13)).append("\n");
		sb.append(helloService.getUserByName("cowboy"));
		System.out.println(sb.toString());
		
		return sb.toString();
	}
	
	@RequestMapping(value="/feign-consumer3",method=RequestMethod.GET)
	String helloConsumer3(){
		StringBuilder sb = new StringBuilder();
		sb.append(helloFeignService4Api.hello()).append("\n");
		sb.append(helloFeignService4Api.hello("cowboy")).append("\n");
		sb.append(helloFeignService4Api.hello(new cowboy.hello_service_api.model.User("cowboy",13))).append("\n");
		sb.append(helloFeignService4Api.HelloById(14)).append("\n");
		sb.append(helloFeignService4Api.hello("cowboy", 13)).append("\n");
		sb.append(helloFeignService4Api.getUserByName("cowboy"));
		System.out.println(sb.toString());
		
		return sb.toString();
	}

}
