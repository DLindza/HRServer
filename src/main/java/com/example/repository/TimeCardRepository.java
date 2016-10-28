package com.example.repository;
import com.example.model.TimeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by sujatharavikumar on 10/26/16.
 */
@Transactional
@RepositoryRestResource(collectionResourceRel = "timecards", path="hrtimecards")
public interface TimeCardRepository  extends CrudRepository<TimeCard, Long> {
    List<TimeCard> findByUserName(@Param("username") String userName);
}
