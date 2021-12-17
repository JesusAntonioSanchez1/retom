/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.repository;


import co.sergioarboleda.retos.entity.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Desarrollo
 */
public interface ClotheCrudRepository extends MongoRepository<Clothe, String>{
    
    public Optional<Clothe> findById(String id); 
    
    public List<Clothe> findByPrice(Integer precio);
    
    public List<Clothe> findByReference(String reference);
    
   // public List<Clothe> findByDescriptionContains(String dc);
   //  public List<Clothe> findByDescriptionLike(String dc);
       public List<Clothe> findByDescriptionContainingIgnoreCase(String title);
    
    
}
