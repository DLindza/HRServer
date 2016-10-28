package com.example.controller;
import com.example.model.TimeCard;
import com.example.repository.TimeCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by sujatharavikumar on 10/26/16.
 */

@RestController
@CrossOrigin(origins = "http://localhost:9000")
public class TimeCardController {



    @Autowired
    TimeCardRepository timeCardRepository;


    @RequestMapping(value = "/timecard", method = RequestMethod.GET)
    public Iterable<TimeCard> getAllTimeCard(){
        return timeCardRepository.findAll();
    }

    @RequestMapping(value = "/timecard" , method = RequestMethod.POST)
    public TimeCard submitTimeCard(@RequestBody TimeCard timeCard){
        timeCardRepository.save(timeCard);
        return timeCard;
    }

    @RequestMapping(value = "/timecard" , method = RequestMethod.OPTIONS)
    public ResponseEntity handle(){
        return new ResponseEntity(HttpStatus.OK);
    }
}
