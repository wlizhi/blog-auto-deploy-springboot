package cc.wlizhi.blogdeployspringboot.config;

import cc.wlizhi.blogdeployspringboot.constant.DeployThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @author Eddie
 */
@Component
@Slf4j
public class DeployDisposableBean implements DisposableBean {
	@Override
	public void destroy() throws Exception {
		log.info("DeployDisposableBean");
		DeployThreadPool.getDeploySinglePool().shutdown();
	}
}
