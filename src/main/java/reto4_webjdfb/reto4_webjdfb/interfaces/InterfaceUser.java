/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto4_webjdfb.reto4_webjdfb.interfaces;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import reto4_webjdfb.reto4_webjdfb.modelo.User;

/**
 *
 * @author JorgeFonseca
 */
public interface InterfaceUser extends MongoRepository<User,Integer> {
    
    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> findTopByOrderByIdDesc();
    List<User> findByMonthBirthtDay(String monthBirthtDay);
    
}
