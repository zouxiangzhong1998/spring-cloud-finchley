package com.carlos.order.repository;

import com.carlos.order.pojo.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Carlos
 * @version 1.0.0
 * @date 2020/5/5 16:11
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
