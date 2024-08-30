package com.orderproductmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderproductmanagement.entity.OrderItemDetails;

@Repository
public interface OrderItemDetailsRepository extends JpaRepository<OrderItemDetails, Long> {

}
