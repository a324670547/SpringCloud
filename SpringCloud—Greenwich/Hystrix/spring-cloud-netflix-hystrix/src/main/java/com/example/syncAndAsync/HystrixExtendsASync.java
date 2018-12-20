package com.example.syncAndAsync;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class HystrixExtendsASync extends HystrixCommand<String> {

    String name;

    protected HystrixExtendsASync(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    /**
     * 要执行的方法
     * @return
     * @throws Exception
     */
    @Override
    protected String run() throws Exception {
        System.out.println(name);
        return name;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 异步
        HystrixExtendsASync testASync1 = new HystrixExtendsASync("name1");
        HystrixExtendsASync testASync2 = new HystrixExtendsASync("name2");
        HystrixExtendsASync testASync3 = new HystrixExtendsASync("name3");
        System.out.println("--------异步调用--------");
        Future<String> future1 = testASync1.queue();
        Future<String> future2 = testASync2.queue();
        Future<String> future3 = testASync3.queue();
        Thread.sleep(1000);
        System.out.println("--------输出返回值--------");
        System.out.println(future1.get());
        System.out.println(future2.get());
        System.out.println(future3.get());
    }

}
