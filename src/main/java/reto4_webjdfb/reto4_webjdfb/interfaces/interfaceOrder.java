package reto4_webjdfb.reto4_webjdfb.interfaces;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import reto4_webjdfb.reto4_webjdfb.modelo.Order;

import java.util.List;
import java.util.Optional;

public interface interfaceOrder extends MongoRepository<Order, Integer> {

    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String zone);


    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);


    Optional<Order> findTopByOrderByIdDesc();
}
