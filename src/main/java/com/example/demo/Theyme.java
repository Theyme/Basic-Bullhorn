package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Theyme {
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
@NotNull
    @Size(min=4)
    private String content;

private Date postedate;

@NotNull
    @Size(min=13)
    private String sentby;

    public Theyme(String life_is_amazing, String s, String s1) {
    }

    public Theyme() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedate() {
        return postedate;
    }

    public void setPostedate(Date postedate) {
        this.postedate = postedate;
    }

    public String getSentby() {
        return sentby;
    }

    public void setSentby(String sentby) {
        this.sentby = sentby;
    }
}
