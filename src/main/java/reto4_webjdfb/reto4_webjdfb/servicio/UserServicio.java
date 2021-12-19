/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reto4_webjdfb.reto4_webjdfb.servicio;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reto4_webjdfb.reto4_webjdfb.modelo.User;
import reto4_webjdfb.reto4_webjdfb.repositorio.UserRepositorio;

/**
 *
 * @author JorgeFonseca
 */
@Service
public class UserServicio {
    
     @Autowired
     private UserRepositorio userRepositorio;
     
     public List<User> getAll(){
         return userRepositorio.getAll();
         
     }
     
     public Optional<User> getUser(int id){
         return userRepositorio.getUser(id);
     }
     
       public boolean emailExists(String email) {
        return userRepositorio.emailExists(email);
    }

    public User create(User user) {


        Optional<User> userIdMaximo = userRepositorio.lastUserId();

        if (user.getId() == null) {
            if (userIdMaximo.isEmpty())
                user.setId(1);
            else
                user.setId(userIdMaximo.get().getId() + 1);
        }

        Optional<User> e = userRepositorio.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail())==false){
                return userRepositorio.create(user);
            }else{
                return user;
            }
        }else{
            return user;
        }

    }
      
       public User update(User user) {

        if (user.getId() != null) {
            Optional<User> userDb = userRepositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                
                userRepositorio.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
       
        public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }
        
        public User authenticateUser(String email, String password) {
        Optional<User> usuario = userRepositorio.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepositorio.birthtDayList(monthBirthtDay);
    }
      
      

}
