package cc.wlizhi.blogdeployspringboot;

import cc.wlizhi.blogdeployspringboot.config.DeployConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(scanBasePackages = "cc.wlizhi.blogdeployspringboot")
@EnableConfigurationProperties(DeployConfig.class)
// @EnableAspectJAutoProxy
public class BlogDeploySpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogDeploySpringbootApplication.class, args);
	}

}
