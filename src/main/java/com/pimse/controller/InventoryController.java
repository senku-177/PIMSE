package com.pimse.controller;

import com.pimse.model.Inventory;
import com.pimse.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @CrossOrigin(origins="*")
    @RequestMapping(value="/get-inventory",method= RequestMethod.GET,produces="application/json")
    public List<Inventory> getAllInventory(){
        return inventoryService.getAllInventoryItems();
    }
}
