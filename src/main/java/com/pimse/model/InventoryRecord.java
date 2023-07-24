package com.pimse.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class InventoryRecord {
    private String productName;
    private double quantity;
    private String uomName;

    public InventoryRecord(String productName, double quantity, String uomName) {
        this.productName = productName;
        this.quantity = quantity;
        this.uomName = uomName;
    }
}
