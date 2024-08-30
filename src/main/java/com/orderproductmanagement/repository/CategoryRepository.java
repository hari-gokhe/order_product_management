package com.orderproductmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderproductmanagement.entity.Category;
import com.orderproductmanagement.entity.User;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
