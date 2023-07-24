package com.pimse.controller;

import com.pimse.model.Customer;
import com.pimse.model.Product;
import com.pimse.model.User;
import com.pimse.model.Vendor;
import com.pimse.repository.CustomerRepository;
import com.pimse.services.CustomerService;
import com.pimse.services.ProductService;
import com.pimse.services.UserService;
import com.pimse.services.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DetailsController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;
    @Autowired
    VendorService vendorService;

    @CrossOrigin(origins="*")
    @RequestMapping(value="/get-customerNo",method= RequestMethod.GET,produces="application/json")
    public long getCustomerNumber(){
        List<Customer> customer=customerService.getAllCustomers();
        return customer.size();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value="/get-productNo",method= RequestMethod.GET,produces="application/json")
    public long getProductNumber(){
        List<Product> product=productService.getAllProducts();
        return product.size();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value="/get-vendorNo",method= RequestMethod.GET,produces="application/json")
    public long getVendorNumber(){
        List<Vendor> vendor=vendorService.getAllVendors();
        return vendor.size();
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value="/get-cashierNo",method= RequestMethod.GET,produces="application/json")
    public long getCashierNumber(){
        List<User> user=userService.getAllUsers();
        long c=0;
        for(int i=0;i<user.size();i++){
            if(user.get(i).getRoleID().getRoleName().equals("Cashier"))
                c++;
        }
        return c;
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value="/get-stockerNo",method= RequestMethod.GET,produces="application/json")
    public long getStockerNumber(){
        List<User> user=userService.getAllUsers();
        long c=0;
        for(int i=0;i<user.size();i++){
            if(user.get(i).getRoleID().getRoleId().equals("STOCK"))
                c++;
        }
        return c;
    }

    @CrossOrigin(origins="*")
    @RequestMapping(value="/get-adminNo",method= RequestMethod.GET,produces="application/json")
    public long getAdminNumber(){
        List<User> user=userService.getAllUsers();
        long c=0;
        for(int i=0;i<user.size();i++){
            if(user.get(i).getRoleID().getRoleName().equals("Administrator"))
                c++;
        }
        return c;
    }
    @CrossOrigin(origins="*")
    @RequestMapping(value="/get-stocker",method= RequestMethod.GET,produces="application/json")
    public List<User> getStocker(){
        List<User> user=userService.getAllUsers();
        List<User> u=new ArrayList<>();
        for(int i=0;i<user.size();i++){
            if(user.get(i).getRoleID().getRoleId().equals("STOCK"))
            u.add(user.get(i));
        }
        return u;
    }
    @CrossOrigin(origins="*")
    @RequestMapping(value="/get-cashier",method= RequestMethod.GET,produces="application/json")
    public List<User> getCashier(){
        List<User> user=userService.getAllUsers();
        List<User> u=new ArrayList<>();
        for(int i=0;i<user.size();i++){
            if(user.get(i).getRoleID().getRoleId().equals("CASH"))
                u.add(user.get(i));
        }
        return u;
    }
}
