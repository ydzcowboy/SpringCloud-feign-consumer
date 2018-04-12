package cowboy.feign_consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class FeignConsumerApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Feign Consumer!" );
        new SpringApplicationBuilder(FeignConsumerApp.class).web(true).run(args);
    }
}
