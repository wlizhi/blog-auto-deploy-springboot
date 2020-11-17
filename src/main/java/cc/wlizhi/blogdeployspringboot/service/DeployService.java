package cc.wlizhi.blogdeployspringboot.service;

import java.io.IOException;

public interface DeployService {
	void init() throws IOException;
	void deploy();
}
