package cc.wlizhi.blogdeployspringboot.other;

import cc.wlizhi.blogdeployspringboot.constant.DeployThreadPool;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.LockSupport;

public class OtherTest {
	@Test
	public void executorTest() throws IOException {
		ExecutorService pool = DeployThreadPool.getDeploySinglePool();
		for (int i = 0; i < 10; i++) {
			final int x = i;
			pool.execute(() -> System.out.println("hello" + x));
		}
		LockSupport.park();
	}
}
