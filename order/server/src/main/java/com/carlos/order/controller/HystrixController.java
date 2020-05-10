package com.carlos.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/10 13:25
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    // fallbackMethod 服务降级，
    @HystrixCommand(/*fallbackMethod = "fallback", */commandProperties = {
            // 超时设置 3秒
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"),
//            // 服务熔断 是否应启用断路器。
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
//            // 断路器 使用统计信息做出打开/关闭决定之前，statisticalWindow内必须发出的请求数。
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            // 断路器 电路跳闸后的毫秒数，然后允许重试。
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//            // 断路器 不能使电路跳闸的“标记”的百分比。
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    @GetMapping("/getProductInfoList")
    public String getProductInfoList(@RequestParam("i") Integer i) {
        if (i == 1) {
            return "成功";
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "成功";
    }

    private String fallback(Integer i) {
        return "太拥挤了，请稍后再试~~";
    }

    private String defaultFallback() {
        return "默认提示：太拥挤了，请稍后再试~~";
    }

}
