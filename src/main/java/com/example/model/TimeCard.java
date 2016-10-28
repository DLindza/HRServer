package com.example.model;

import com.example.utils.JsonDateDeserializer;
import com.example.utils.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sujatharavikumar on 10/26/16.
 */
@Entity
public class TimeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String startTime;
    private String endTime;
    private Date date;

    @Transient
    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public TimeCard(){
        userName = "";
        startTime = "";
        endTime = "";
        date = new Date();
    }


    public TimeCard(String userName, String startTime, String endTime) {
        this.userName = userName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = new Date();
    }

    public TimeCard(String userName, String startTime, String endTime, String date) {
        this.userName = userName;
        this.startTime = startTime;
        this.endTime = endTime;
        try {
            this.date = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "TimeCard{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", date=" + date +
                '}';
    }
}
