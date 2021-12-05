/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;

import co.sergioarboleda.retos.entity.Order;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    
    @Autowired
    private OrderCrudRepository orderCrudRepository;
    
    //Get ALl
    public List<Order> getAll(){
        return (List<Order>) orderCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Order> getUserById(int id){
        return orderCrudRepository.findById(id);
    }
    
    //SAVE
    public Order save(Order order){
        return orderCrudRepository.save(order);
    }
    
    public void delete (Integer id){
        orderCrudRepository.deleteById(id);
    }

    public void deleteById (Integer id){
        orderCrudRepository.deleteById(id);
    }
    
    /**
     * 
     * @param zona
     * @return
     */
    public List<Order> getOrderByZone(String zona){
        return  orderCrudRepository.findByZone(zona);
    }
    
     public List<Order> getOrderByStatus(String status){
        return  orderCrudRepository.findByStatus(status);
    }


    
}
