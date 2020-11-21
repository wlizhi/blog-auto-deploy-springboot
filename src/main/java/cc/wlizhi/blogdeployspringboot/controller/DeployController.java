package cc.wlizhi.blogdeployspringboot.controller;

import cc.wlizhi.blogdeployspringboot.config.DeployConfig;
import cc.wlizhi.blogdeployspringboot.constant.ResStatusEnum;
import cc.wlizhi.blogdeployspringboot.model.ResModel;
import cc.wlizhi.blogdeployspringboot.service.DeployService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

/**
 * @author Eddie
 */
@RestController
@Slf4j
public class DeployController {
	@Autowired
	private DeployService deployService;
	@Autowired
	DeployConfig deployConfig;

	@RequestMapping("/deploy")
	public ResModel<?> deploy(Map<String, Object> paramMap) {
		log.info("收到github的请求，参数内容:{},自动部署myblog...", paramMap);
		deployService.deploy();
		return ResModel.response(ResStatusEnum.R200, new Date());
	}
}
