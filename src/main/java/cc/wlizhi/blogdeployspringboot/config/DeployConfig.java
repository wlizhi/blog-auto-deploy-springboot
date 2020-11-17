package cc.wlizhi.blogdeployspringboot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Eddie
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "deploy")
public class DeployConfig {
	private String gitRepository;
	private String gitUserName;
	private String gitPassWord;
	private String htmlRootName;
}
