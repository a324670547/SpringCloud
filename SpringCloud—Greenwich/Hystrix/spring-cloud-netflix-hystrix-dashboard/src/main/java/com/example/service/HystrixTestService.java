package com.example.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class HystrixTestService {

    /*******************************Service******************************/

    /**
     * 测试的service,返回测试值
     * @return
     */
    @HystrixCommand(fallbackMethod = "errorValue")
    public String getTestValue() {
        if(isCreateException){
            throw new RuntimeException("");
        }
        return "Hello World!";
    }

    /**
     * 服务降级时返回的值
     * @return
     */
    public String errorValue() {
        return "error";
    }

    /*******************************创建一个异常******************************/

    // 异常控制开关
    private static boolean isCreateException = false;

    {
        // 初始化时候静态块，启动一个20s后开启异常的定时器
        createErrorTimer(10000);
    }

    /**
     * 定时器
     * 方便测试，20s后改变testValue值为一个异常值
     * @param time
     */
    public static void createErrorTimer(int time) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                // 改变testValue值为一个异常的值
                isCreateException = true;
            }
        }, time);
    }
}