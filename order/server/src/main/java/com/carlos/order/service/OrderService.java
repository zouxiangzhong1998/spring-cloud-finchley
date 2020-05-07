package com.carlos.order.service;

import com.carlos.order.dto.OrderDTO;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:11
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 完结订单(只能卖家操作)
     * @param orderId
     * @return
     */
    OrderDTO finish(String orderId);
}
