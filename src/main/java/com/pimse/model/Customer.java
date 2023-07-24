package com.pimse.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long customerId;

    @Column(unique = true)
    private String customerName;
    private String mobileNumber;
    private String e_mail;
    
    @Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdDate=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
    
    @Column(name="modifiedDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private  String modifiedDate=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
}