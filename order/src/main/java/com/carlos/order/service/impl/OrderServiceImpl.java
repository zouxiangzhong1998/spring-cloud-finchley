package com.carlos.order.service.impl;

import com.carlos.order.dto.OrderDTO;
import com.carlos.order.enums.OrderStatusEnum;
import com.carlos.order.enums.PayStatusEnum;
import com.carlos.order.pojo.OrderMaster;
import com.carlos.order.repository.OrderDetailRepository;
import com.carlos.order.repository.OrderMasterRepository;
import com.carlos.order.service.OrderService;
import com.carlos.order.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 17:53
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;


    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        // TODO 查询商品信息(调用商品服务)
        // TODO 计算总价
        // TODO 扣库存（调用商品服务）

        // 订单入库
        Date date = new Date();
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setCreateTime(date);
        orderMaster.setUpdateTime(date);
        orderMasterRepository.save(orderMaster);
        return orderDTO;
    }

    @Override
    public OrderDTO finish(String orderId) {
        return null;
    }
}
