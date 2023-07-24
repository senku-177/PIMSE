package com.pimse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "purchaseInvoice")
public class PurchaseInvoice {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long purchaseInvoiceId;

	@OneToMany(cascade = CascadeType.ALL)
    private List<PurchaseOrderItem> orderItemList;

    @ManyToOne
    private Vendor vendors;
    
    @Column(name="createdDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private String createdDate=new Date().toString();
    
    @Column(name="modifiedDate", columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private  String modifiedDat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(Calendar.getInstance().getTime());
    
}
