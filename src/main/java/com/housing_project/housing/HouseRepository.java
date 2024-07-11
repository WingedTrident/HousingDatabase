package com.housing_project.housing;
import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface HouseRepository extends CrudRepository<House, Integer>{
    
    List<House> findByIsSoldTrue();

}
