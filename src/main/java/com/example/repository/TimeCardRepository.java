package com.example.repository;
import com.example.model.TimeCard;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sujatharavikumar on 10/26/16.
 */
public interface TimeCardRepository  extends CrudRepository<TimeCard, Long>{
    
}
