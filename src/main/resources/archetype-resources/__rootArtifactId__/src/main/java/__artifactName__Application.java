#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

/**
 * The spring-boot application runtime class
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableFeignClients
@EnableCaching
@EnableHystrix
@Import(PartnerConfig.class)
public class ${artifactName}Application {

	/**
	 * Runs the spring-boot application with this class and any command-line arguments.
	 *
	 * @param args the array or command-line arguments
	 */
    public static void main(String[] args) {
        SpringApplication.run(${artifactName}Application.class, args);
    }

	/**
	 * The spring sleuth sampler bean
	 * 
	 * @return AlwaysSampler
	 */
	@Bean
	AlwaysSampler alwaysSampler() {
		return new AlwaysSampler();
	}
}