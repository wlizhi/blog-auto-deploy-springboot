package cc.wlizhi.blogdeployspringboot.constant;

import java.util.concurrent.*;

/**
 * @author Eddie
 */
public class DeployThreadPool {
	private static int deploySinglePoolThreadNameCounter;
	public static ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(200);
	private static final ThreadPoolExecutor deploySinglePool = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS,
			queue);

	public static ExecutorService getDeploySinglePool(){
		return deploySinglePool;
	}
}
