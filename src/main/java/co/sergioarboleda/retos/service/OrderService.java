/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.service;

import co.sergioarboleda.retos.entity.Order;
import co.sergioarboleda.retos.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll(){
        return orderRepository.getAll();
    }
  
    public Optional<Order> getUser(int id){
        return orderRepository.getUserById(id);
    }
    
     public Order save(Order order){
        if(order.getRegisterDay() == null || order.getStatus()==null || order.getSalesMan()==null){
            return order;
        }else{
               Optional<Order> existUser2 = orderRepository.getUserById(order.getId());
                    if(existUser2.isEmpty()){
                        return orderRepository.save(order);
                    }else{
                        return order;
                    }
             
            }
        }
     
     public Order update(Order order){
        if(order.getId()!=null){
            Optional<Order> orderExist = orderRepository.getUserById(order.getId());
            if(orderExist.isPresent()){
                if(order.getRegisterDay()!=null){
                    orderExist.get().setRegisterDay(order.getRegisterDay());
                }
                if(order.getStatus()!=null){
                    orderExist.get().setStatus(order.getStatus());
                }
                if(order.getSalesMan()!=null){
                    orderExist.get().setSalesMan(order.getSalesMan());
                }
                
                return orderRepository.save(orderExist.get());
            }else{
                return order;
            }
        }else{
            return order;
        }
    }
     
     public Integer deleteById(Integer id){
        Optional<Order> clone = orderRepository.getUserById(id);
        if(clone.isPresent()){
            orderRepository.deleteById(id);
            return null;
        }else{
            return id;
        }
    }
     
     /**
     *
     * @param zona
     * @return
     */
    public List<Order> getOrdersByZone(String zona){
        return orderRepository.getOrderByZone(zona);
    }
    
    public List<Order> getOrdersByStatus(String status){
        return orderRepository.getOrderByStatus(status);
    }
    
    public Order getUserById(Integer id){
        /*Optional<User> usuario = repository.getUserById(id);
        if(usuario.isPresent()){
            return usuario.get();
        }else{
            return  new User;
        }*/
        return orderRepository.getUserById(id).orElse(new Order());
    }
    
     public List<Order> getOrdersBySalesman(Integer ids){
        return orderRepository.getOrderBySalesman(ids);
    }
    
    public List<Order> getOrdersByStatusAndId(String status, Integer ids){
        return orderRepository.getOrdersByStatusAndId(status,ids);
        
    }
    
    
    
    
    public List <Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        return orderRepository.getByRegisterDayAndSalesManId(registerDay,id);
   
     }

     

     
    
}
