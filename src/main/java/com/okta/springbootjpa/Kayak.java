package com.okta.springbootjpa;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
public class Kayak {

    public Kayak(String name, String owner, Number value, String makeModel, Long date) {
        this.name = name;
        this.owner = owner;
        this.value = value;
        this.makeModel = makeModel;
        this.date = new Date(date);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private final String name;
    private String owner;
    private Number value;
    private String makeModel;
    private Date date;
}
