/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.controller;

import co.sergioarboleda.retos.entity.Order;
import co.sergioarboleda.retos.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    
     @Autowired
    private OrderService orderService;
     
     @GetMapping("/all")
    public List<Order> getUsers(){
        return orderService.getAll();
    }
    
    @GetMapping("/zona/{zona}")
    public List<Order> getOrdersByZone(@PathVariable("zona") String zona){
        return orderService.getOrdersByZone(zona);
    }
    
    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable("status") String status){
        return orderService.getOrdersByStatus(status);
    }

    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        return orderService.save(order);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update (@RequestBody Order order){
        return orderService.update(order);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer delete(@PathVariable("id") Integer id){
       return orderService.deleteById(id);
    }
    
    @GetMapping("/{id}")
    public Order getUser(@PathVariable("id") Integer id){
        return orderService.getUserById(id);
    }

    
        
}
