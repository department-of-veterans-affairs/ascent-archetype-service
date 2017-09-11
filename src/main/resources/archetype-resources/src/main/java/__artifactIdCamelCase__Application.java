package ${groupId};

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableFeignClients
@EnableCaching
@EnableHystrix
public class ${artifactIdCamelCase}Application {

    public static void main(String[] args) {
        SpringApplication.run(${artifactIdCamelCase}Application.class, args);
    }

}
