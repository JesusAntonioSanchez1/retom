/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.service;

import co.sergioarboleda.retos.entity.Clothe;
import co.sergioarboleda.retos.repository.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClotheService {
    
    @Autowired
    private ClotheRepository clotheRepository;
    
    public List<Clothe> getAll(){
        return clotheRepository.getAll();
    }
  
    public Optional<Clothe> getUser(String id){
        return clotheRepository.getUserById(id);
    }
    
     public Clothe save(Clothe clothe){
        if(clothe.getCategory() == null || clothe.getSize()==null || clothe.getDescription()==null || 
             clothe.getPhotography()==null){
            return clothe;
        }else{
               Optional<Clothe> existClothe = clotheRepository.getUserById(clothe.getReference());
                    if(existClothe.isEmpty()){
                        return clotheRepository.save(clothe);
                    }else{
                        return clothe;
                    }
             
            }
        }
     
     
     public Clothe update(Clothe clothe){
        if(clothe.getReference()!=null){
            Optional<Clothe> clotheExist = clotheRepository.getUserById(clothe.getReference());
            if(clotheExist.isPresent()){
                if(clothe.getCategory()!=null){
                    clotheExist.get().setCategory(clothe.getCategory());
                }
                  if(clothe.getDescription()!=null){
                    clotheExist.get().setDescription(clothe.getDescription());
                }
                if(clothe.getSize()!=null){
                    clotheExist.get().setSize(clothe.getSize());
                }
               
                if(clothe.getPhotography()!=null){
                    clotheExist.get().setPhotography(clothe.getPhotography());
                }
                
                 if(clothe.getQuantity()!=0){
                    clotheExist.get().setQuantity(clothe.getQuantity());
                }
                 
                 if(clothe.getPrice()!=0){
                    clotheExist.get().setPrice(clothe.getPrice());
                }
                return clotheRepository.save(clotheExist.get());
            }else{
                return clothe;
            }
        }else{
            return clothe;
        }
    }
     
     
     
     
     public String deleteById(String id){
        Optional<Clothe> clone = clotheRepository.getUserById(id);
        if(clone.isPresent()){
            clotheRepository.deleteById(id);
            return null;
        }else{
            return id;
        }
    }
     
      public List<Clothe> getClotheByPrice(Integer precio){
        return clotheRepository.getClotheByPrice(precio);
    }
      
      public List<Clothe> getClotheByDescription(String dc){
        return clotheRepository.getClotheByDescription(dc);
    }
      
      public Clothe getClotheByReference(String reference){
        return clotheRepository.getClotheByReference(reference).orElse(new Clothe());  
      //  return clotheRepository.getClotheByReference(reference);
    }
   
}
