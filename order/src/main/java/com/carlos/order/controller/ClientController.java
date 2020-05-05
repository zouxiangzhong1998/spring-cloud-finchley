package com.carlos.order.controller;

import com.carlos.order.client.ProductClient;
import com.carlos.order.pojo.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 18:42
 */
@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.msg();
        log.info("response = {}", response);
        return response;
    }

    @GetMapping("/getListForOrder")
    public String listForOrder() {
        List<ProductInfo> productInfos = productClient.listForOrder(Arrays.asList("157875196366160022", "157875227953464068"));
        log.info("productInfos = {}", productInfos);
        return "ok";
    }

//    @GetMapping("/getProductMsg")
//    public String getProductMsg() {
//        // 1.第一种方式（直接使用restTemplate,url写死）
////        RestTemplate restTemplate = new RestTemplate();
////        String response = restTemplate.getForObject("http://localhost:8080/msg", String.class);
//
//        // 2.第二种方式（利用loadBalancerClient 通过应用名获取URL，然后在使用restTemplate）
////        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
////        String url = String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort() + "/msg");
////        String response = restTemplate.getForObject(url, String.class);
//
//        // 3.第三种方式(利用@LoadBalanced,可在restTemplate里使用应用名字)
//        String response = restTemplate.getForObject("http://PRODUCT/msg", String.class);
//        log.info("response = {}", response);
//        return response;
//    }

}
