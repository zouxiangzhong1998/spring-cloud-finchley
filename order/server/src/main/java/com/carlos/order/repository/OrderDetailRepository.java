package com.carlos.order.repository;

import com.carlos.order.pojo.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:11
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

	/**
	 * 根据 订单ID 查询订单详情
	 * @param orderId
	 * @return
	 */
	List<OrderDetail> findByOrderId(String orderId);

}
