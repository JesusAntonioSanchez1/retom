/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;

import co.sergioarboleda.retos.entity.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClotheRepository {
    
    @Autowired
    private ClotheCrudRepository clotheCrudRepository;
    
    //Get ALl
    public List<Clothe> getAll(){
        return (List<Clothe>) clotheCrudRepository.findAll();
    }
    
    //Get por Id
    public Optional <Clothe> getUserById(String id){
        return clotheCrudRepository.findById(id);
    }
    
     public Clothe save(Clothe clothe){
        return clotheCrudRepository.save(clothe);
    }
     
     public void delete (String id){
        clotheCrudRepository.deleteById(id);
    }

    public void deleteById (String id){
        clotheCrudRepository.deleteById(id);
    }
    
    
}
