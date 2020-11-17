package cc.wlizhi.blogdeployspringboot.service.impl;

import cc.wlizhi.blogdeployspringboot.constant.DeployThreadPool;
import cc.wlizhi.blogdeployspringboot.service.DeployService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

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

	@Override
	public void init() throws IOException {
		ClassPathResource resource = new ClassPathResource("deploy.sh");
		BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		String lineContent;
		while ((lineContent = reader.readLine()) != null) {
			shellCommandList.add(lineContent);
		}
	}

	@Override
	public void deploy() {
		// for (String command : shellCommandList) {
		// 	try {
		// 		Process exec = Runtime.getRuntime().exec(command);
		// 		exec.waitFor();
		// 	} catch (InterruptedException | IOException e) {
		// 		log.warn(e.getMessage(), e);
		// 	}
		// }
		ExecutorService pool = DeployThreadPool.getDeploySinglePool();
		pool.execute(() -> {
			try {
				for (String command : shellCommandList) {
					Process exec = Runtime.getRuntime().exec(command);
					exec.waitFor();
				}
			} catch (IOException | InterruptedException e) {
				log.warn(e.getMessage(), e);
			}
		});
	}
}
