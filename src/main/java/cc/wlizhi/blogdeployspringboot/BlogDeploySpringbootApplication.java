package cc.wlizhi.blogdeployspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Eddie
 */
@SpringBootApplication(scanBasePackages = "cc.wlizhi.blogdeployspringboot")
public class BlogDeploySpringbootApplication {

	public static void main(String[] args) {

		SpringApplication.run(BlogDeploySpringbootApplication.class, args);
	}

}
