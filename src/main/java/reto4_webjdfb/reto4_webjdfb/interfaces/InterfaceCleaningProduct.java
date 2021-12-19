/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto4_webjdfb.reto4_webjdfb.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import reto4_webjdfb.reto4_webjdfb.modelo.CleaningProduct;

import java.util.List;

/**
 *
 * @author JorgeFonseca
 */
public interface InterfaceCleaningProduct extends MongoRepository<CleaningProduct, String>{

    public List<CleaningProduct> findByPriceLessThanEqual(double precio);
    @Query("{'description':{'$regex':'?0','$options':'i'}}")

    public List<CleaningProduct> findByDescriptionLike(String description);



}
