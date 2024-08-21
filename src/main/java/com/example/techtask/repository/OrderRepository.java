package com.example.techtask.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.techtask.model.Order;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    @Query(value = "select id, price, quantity, product_name, user_id, created_at, order_status from orders where id in (select id from orders where quantity > 1 order by created_at desc limit 1)", nativeQuery = true)
    public Order findOrder();

    @Query(value = "select o.id, o.price, o.quantity, o.product_name, o.user_id, o.created_at, o.order_status from orders as o join users as u on u.id = o.user_id where user_status = 'ACTIVE' order by created_at desc", nativeQuery = true)
    public List<Order> findOrders();
}
