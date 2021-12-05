/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;

import co.sergioarboleda.retos.entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Desarrollo
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {
    
     public Optional<Order> findById(String id);
     @Query("{'salesMan.zone':?0}")
     public List<Order> findByZone(String country );
     
     public List<Order> findByStatus(String status );
    
}
