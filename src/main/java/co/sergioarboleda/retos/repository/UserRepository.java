/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;


import co.sergioarboleda.retos.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    //Get ALl
    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <User> getUserById(int id){
        return userCrudRepository.findById(id);
    }
    
    //SAVE
    public User save(User user){
        return userCrudRepository.save(user);
    }

     public Optional<User> getUserByName(String name){
        return userCrudRepository.findByName(name);
    }
    
    public Optional<User> getUserByEmail(String email){
        return userCrudRepository.findByEmail(email);
    }

    public List<User> getUserByNameOrEmail(String name ,String email){
        return userCrudRepository.findByNameOrEmail(name,email);
    }

    public Optional<User> getUserEmailAndPassword(String email,String password){
        return userCrudRepository.findByEmailAndPassword(email,password);
    }


    
    public void delete (Integer id){
        userCrudRepository.deleteById(id);
    }

    public void deleteById (Integer id){
        userCrudRepository.deleteById(id);
    }
    
}
