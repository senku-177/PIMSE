package com.pimse.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRowRequest {
    private String productName;
    private double quantity;
}
