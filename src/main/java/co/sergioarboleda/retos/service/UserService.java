/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.service;


import co.sergioarboleda.retos.entity.User;
import co.sergioarboleda.retos.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cktv
 */
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll(){
        return userRepository.getAll();
    }
  
    public Optional<User> getUser(int id){
        return userRepository.getUserById(id);
    }
    
    
    

    public User save(User user){
        if(user.getName() == null || user.getEmail()==null || user.getPassword()==null
                || user.getIdentification()==null || user.getType()==null){
            return user;
        }else{
            List<User> existUser = userRepository.getUserByNameOrEmail(user.getName(),user.getEmail());
            if(existUser.isEmpty()){
                if(user.getId()==null){
                    return userRepository.save(user);
                }else{
                    Optional<User> existUser2 = userRepository.getUserById(user.getId());
                    if(existUser2.isEmpty()){
                        return userRepository.save(user);
                    }else{
                        return user;
                    }
                }
            }else{
                return user;
            }
        }
    }
    
    
     public boolean getUserByEmail(String email){
        return userRepository.getUserByEmail(email).isPresent();
     }
     
      public User getByEmailPass(String email, String password){
        Optional <User> userExist = userRepository.getUserEmailAndPassword(email, password);
        if(userExist.isPresent()){
            return userExist.get();
        }else{
            return new User();
        }
     }
    
      public User update(User user){
        if(user.getId()!=null){
            Optional<User> userExist = userRepository.getUserById(user.getId());
            if(userExist.isPresent()){
                if(user.getIdentification()!=null){
                    userExist.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userExist.get().setName(user.getName());
                }
                if(user.getAddress()!=null){
                    userExist.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userExist.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userExist.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userExist.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userExist.get().setType(user.getType());
                }
                return userRepository.save(userExist.get());
            }else{
                return user;
            }
        }else{
            return user;
        }
    }
    /*
    public boolean deleteUser(int id){
        Boolean aBoolean=getUser(id).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(aBoolean=false);
        
        return aBoolean;
    }
    */
       public Integer deleteById(Integer id){
        Optional<User> user = userRepository.getUserById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return null;
        }else{
            return id;
        }
    }
}
