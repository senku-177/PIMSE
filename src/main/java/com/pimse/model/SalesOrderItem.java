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
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity(name = "SalesOrderItem")
@ToString
public class SalesOrderItem {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long salesOrderItemId;

    @ManyToOne
    private Product product;
    private Double quantity;
    private Double price;
    private Double taxPercentage;
    
    @Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdDate=new Date().toString();
    
    @Column(name="modifiedDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private  String modifiedDate=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());





}
