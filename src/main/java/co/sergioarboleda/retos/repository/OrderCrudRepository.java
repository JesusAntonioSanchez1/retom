/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;

import co.sergioarboleda.retos.entity.Order;
import java.util.Date;
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
     
     @Query("{'salesMan.id':?0}")
     public List<Order> findBySalesman(Integer ids );
     
     @Query("{'status':?0,'salesMan.id':?1}")
     public List<Order> findByStatusAndId(String status, Integer ids );
     
    
  
     public List<Order> findByRegisterDayAndSalesManId(Date registerDay,Integer id);
    
}
