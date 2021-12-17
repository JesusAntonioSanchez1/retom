/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.sergioarboleda.retos.controller;

import co.sergioarboleda.retos.entity.Clothe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.sergioarboleda.retos.service.ClotheService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/clothe")
public class ClotheController {
    
    @Autowired
    private ClotheService clotheService;
    
    @GetMapping("/all")
    public List<Clothe> getUsers(){
        return clotheService.getAll();
    }
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe save(@RequestBody Clothe clothe){
        return clotheService.save(clothe);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clothe update (@RequestBody Clothe clothe){
        return clotheService.update(clothe);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String delete(@PathVariable("id") String id){
       return clotheService.deleteById(id);
    }
    
    @GetMapping("/price/{precio}")
    public List<Clothe> getCloneByPrice(@PathVariable("precio") Integer precio){
        return clotheService.getClotheByPrice(precio);
    }
    
    @GetMapping("/description/{dc}")
    public List<Clothe> getCloneByDescription(@PathVariable("dc") String dc){
        return clotheService.getClotheByDescription(dc);
    }
    
     @GetMapping("/{reference}")
    public List<Clothe> getClotheByReference(@PathVariable("reference") String reference){
        return clotheService.getClotheByReference(reference);
    }
    
    
}
