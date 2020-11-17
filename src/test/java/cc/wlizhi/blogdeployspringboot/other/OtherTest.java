package cc.wlizhi.blogdeployspringboot.other;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.concurrent.locks.LockSupport;

public class OtherTest {
	@Test
	public void executorTest() throws IOException {
		Process exec = Runtime.getRuntime().exec("echo \"hello world\" >> a.txt");
		InputStream rs = exec.getErrorStream();
		InputStream is = exec.getInputStream();
		OutputStream os = exec.getOutputStream();
		BufferedReader brrs = new BufferedReader(new InputStreamReader(rs));
		BufferedReader bris = new BufferedReader(new InputStreamReader(is));
		System.out.println(brrs.readLine());
		System.out.println(bris.readLine());
		os.flush();
		LockSupport.park(1000_000);
	}
}
