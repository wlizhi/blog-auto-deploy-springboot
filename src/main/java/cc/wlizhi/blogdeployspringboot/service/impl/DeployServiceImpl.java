package cc.wlizhi.blogdeployspringboot.service.impl;

import cc.wlizhi.blogdeployspringboot.constant.DeployThreadPool;
import cc.wlizhi.blogdeployspringboot.service.DeployService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * @author Eddie
 */
@Service
@Slf4j
public class DeployServiceImpl implements DeployService {
	private final List<String> shellCommandList = new ArrayList<>();

	@PostConstruct
	private void init() throws IOException {
		ClassPathResource resource = new ClassPathResource("deploy.sh");
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String lineContent;
		while ((lineContent = reader.readLine()) != null) {
			shellCommandList.add(lineContent);
		}
	}

	@Override
	public void deploy() {
		ExecutorService pool = DeployThreadPool.getDeploySinglePool();
		pool.submit(() -> {
			log.info("线程:[{}]收到任务，开始动态部署myblog...", Thread.currentThread().getName());
			try {
				for (String command : shellCommandList) {
					log.info("执行指令:{}", command);
					Process exec = Runtime.getRuntime().exec(command);
					exec.waitFor();
				}
				log.info("^_^动态部署完毕^_^");
			} catch (IOException | InterruptedException e) {
				log.warn("(⊙︿⊙)动态部署异常(⊙︿⊙)");
				log.warn(e.getMessage(), e);
			}
		});
	}
}
