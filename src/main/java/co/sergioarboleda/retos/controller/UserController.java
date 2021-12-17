/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.controller;


import java.util.List;
import java.util.Optional;
import co.sergioarboleda.retos.service.UserService;
import co.sergioarboleda.retos.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    //Listar tabla user
    
    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getAll();
    }
    
    ///Crear Usuario
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    //Verificar si correo existe
    
    @GetMapping("/emailexist/{email}")
    public boolean existEmail(@PathVariable("email") String email){
        return userService.getUserByEmail(email);
    }
    //Validar por Correo y Clave
    
    @GetMapping("/{email}/{password}")
    public User existUser(@PathVariable("email") String email , @PathVariable("password") String password){
        return userService.getByEmailPass(email, password);
    }
    
    
    // Actualizar Usuario
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User update (@RequestBody User user){
        return userService.update(user);
    }

    //Borrar Usuario Por id
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer delete(@PathVariable("id") Integer id){
       return userService.deleteById(id);
    }
    
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return userService.getUserById(id);
    }
    
    @GetMapping("/birthday/{monthBirthtDay}")
    public List<User> getByMonthBirthtDay(@PathVariable("monthBirthtDay") String monthBirthtDay ){
        return userService.getByMonthBirthtDay(monthBirthtDay);
    }
    
    

}
