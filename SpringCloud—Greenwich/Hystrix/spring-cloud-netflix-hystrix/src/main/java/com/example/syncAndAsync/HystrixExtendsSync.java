package com.example.syncAndAsync;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.concurrent.ExecutionException;

public class HystrixExtendsSync extends HystrixCommand<String> {

    int timeout = 0;

    protected HystrixExtendsSync(int timeout) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.timeout = timeout;
    }

    /**
     * 要执行的方法
     * @return
     * @throws Exception
     */
    @Override
    protected String run() throws Exception {
        System.out.println("调用Run");
        // 为了方便测试,设置一个超时时间
        Thread.sleep(timeout);
        return "hello world";
    }

    /**
     * 当run()方法发生异常时，服务降级调用此方法
     * @return
     */
    @Override
    protected String getFallback() {
        System.out.println("调用Fallback");
        return "error";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 同步
        HystrixExtendsSync testRun = new HystrixExtendsSync(100);
        System.out.println("--------同步--------");
        System.out.println(testRun.execute());
        HystrixExtendsSync testFallback = new HystrixExtendsSync(2000);
        System.out.println(testFallback.execute());
    }

}
