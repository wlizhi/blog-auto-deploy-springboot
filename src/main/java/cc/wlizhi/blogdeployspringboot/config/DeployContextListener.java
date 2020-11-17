package cc.wlizhi.blogdeployspringboot.config;

import cc.wlizhi.blogdeployspringboot.service.DeployService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Eddie
 */
@Slf4j
@Component
public class DeployContextListener implements ApplicationListener<ContextRefreshedEvent> {
	private AtomicBoolean hasInit = new AtomicBoolean(false);
	@Autowired
	private DeployService deployService;

	@SneakyThrows
	@Override
	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		boolean inited = hasInit.getAndSet(true);
		if (inited){
			return;
		}
		deployService.init();
	}
}
