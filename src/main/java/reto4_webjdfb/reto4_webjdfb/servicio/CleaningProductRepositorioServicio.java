/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto4_webjdfb.reto4_webjdfb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import reto4_webjdfb.reto4_webjdfb.modelo.CleaningProduct;
import reto4_webjdfb.reto4_webjdfb.repositorio.CleaningProductRepositorio;

/**
 *
 * @author JorgeFonseca
 */
@Service
public class CleaningProductRepositorioServicio {
    
    @Autowired
    private CleaningProductRepositorio  productRespositorio;

    @Autowired
    private MongoTemplate mongoTemplate;
    
    public List<CleaningProduct> getAll() {
        return productRespositorio.getAll();
    }
    
    public Optional<CleaningProduct> getClothe(String reference) {
        return productRespositorio.getProduct(reference);
    }
    
    public CleaningProduct create(CleaningProduct accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return productRespositorio.create(accesory);
        }
    }
    
    public CleaningProduct update(CleaningProduct accesory) {

        if (accesory.getReference() != null) {
            Optional<CleaningProduct> accesoryDb = productRespositorio.getProduct(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                
                if (accesory.getMaterial() != null) {
                    accesoryDb.get().setMaterial(accesory.getMaterial());
                }
                 
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                productRespositorio.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }
    
    
     public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            productRespositorio.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<CleaningProduct> productByPrice(double precio) {
        return productRespositorio.productByPrice(precio);
    }

    public List<CleaningProduct> findByDescriptionLike(String description) {
        return productRespositorio.findByDescriptionLike(description);
    }








}
