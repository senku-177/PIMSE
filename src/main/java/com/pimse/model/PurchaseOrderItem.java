package com.pimse.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PurchaseOrderItem {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO )
    private Long PurchaseOrderItemId;

    @ManyToOne
    private Product product;
    private Double quantity;
    private Double price;
    private Double taxPercentage;
    
    @Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdDate=new Date().toString();

}