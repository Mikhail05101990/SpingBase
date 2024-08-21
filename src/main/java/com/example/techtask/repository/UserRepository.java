package com.example.techtask.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.techtask.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select id, email, user_status from Users where id in (select user_id from Orders where date_part('year', created_at) = 2003 AND order_status = 'DELIVERED' group by user_id order by Sum(price) desc limit 1)", nativeQuery = true)
    public User findUser();

    @Query(value = "select id, email, user_status from Users where id in (select user_id from Orders where date_part('year', created_at) = 2010 AND order_status = 'PAID' group by user_id)", nativeQuery = true)
    public List<User> findUsers();
}
