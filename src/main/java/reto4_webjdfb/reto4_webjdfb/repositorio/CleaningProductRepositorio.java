/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto4_webjdfb.reto4_webjdfb.repositorio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reto4_webjdfb.reto4_webjdfb.interfaces.InterfaceCleaningProduct;
import reto4_webjdfb.reto4_webjdfb.modelo.CleaningProduct;

/**
 *
 * @author JorgeFonseca
 */
@Repository
public class CleaningProductRepositorio {
    
    @Autowired
    private InterfaceCleaningProduct repositorioProduct;
    
    public List<CleaningProduct> getAll(){
        
        return repositorioProduct.findAll();    
    }
    
    public Optional<CleaningProduct> getProduct(String reference){
        return repositorioProduct.findById(reference);
    }
    
    public CleaningProduct create(CleaningProduct product){
        return repositorioProduct.save(product);
    }
    
    public void update(CleaningProduct product){
        repositorioProduct.save(product);
    
    }
    
    public void delete(CleaningProduct product){
        repositorioProduct.delete(product);
    }

    public List<CleaningProduct> productByPrice(double precio) {
        return repositorioProduct.findByPriceLessThanEqual(precio);
    }

    public List<CleaningProduct> findByDescriptionLike(String description) {
        return repositorioProduct.findByDescriptionLike(description);
    }




}
