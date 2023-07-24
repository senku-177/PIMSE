package com.pimse.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PurchaseInvoiceRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long purchaseInvoiceId;

    @OneToMany(mappedBy="product")
    private List<OrderItemRequest> orderItemList;

    @ManyToOne
    private Vendor vendors;
    
    @Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdDate=new Date().toString();
    
    @Column(name="modifiedDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private  String modifiedDate=new Date().toString();
}
