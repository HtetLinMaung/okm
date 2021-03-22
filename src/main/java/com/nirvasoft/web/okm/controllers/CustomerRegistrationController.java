package com.nirvasoft.web.okm.controllers;

import java.util.List;

import com.nirvasoft.web.okm.models.AddressData;
import com.nirvasoft.web.okm.models.ComboData;
import com.nirvasoft.web.okm.models.CountryData;
import com.nirvasoft.web.okm.models.CustomerData;
import com.nirvasoft.web.okm.models.FilterRequest;
import com.nirvasoft.web.okm.models.NameTitleData;
import com.nirvasoft.web.okm.models.ResponseData;
import com.nirvasoft.web.okm.services.CustomerRegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer-registrations")
@CrossOrigin
public class CustomerRegistrationController {
    private final CustomerRegistrationService crService;

    @Autowired
    public CustomerRegistrationController(CustomerRegistrationService crService) {
        this.crService = crService;
    }

    @PostMapping
    public ResponseEntity<ResponseData> registerCustomer(@RequestBody CustomerData data) {
        ResponseData res = new ResponseData();
        int success = crService.registerCustomer(data);

        if (success == 1) {
            res.setMessage("Customer register successful");
        } else {
            res.setMessage("Something went wrong");
        }

        return ResponseEntity.status(201).body(res);
    }

    @GetMapping
    public List<CustomerData> fetchAllCustomers() {
        return crService.fetchAllCustomers();
    }

    @PostMapping(path = "search")
    public List<CustomerData> fetchCustomers(@RequestBody FilterRequest req) {
        return crService.fetchCustomers(req);
    }

    @PostMapping(path = "customer-types")
    public List<ComboData> fetchAllCustomerTypes(@RequestBody FilterRequest req) {
        return crService.fetchAllCustomerTypes(req);
    }

    @GetMapping(path = "occupations")
    public List<ComboData> fetchAllOccupation() {
        return crService.fetchAllOccupation();
    }

    @GetMapping(path = "name-titles")
    public List<NameTitleData> fetchAllNameTitles() {
        return crService.fetchAllNameTitle();
    }

    @GetMapping(path = "countries")
    public List<CountryData> fetchAllCountries() {
        return crService.fetchAllCountries();
    }

    @GetMapping(path = "addresses")
    public List<AddressData> fetchAllAddress() {
        return crService.fetchAllAddress();
    }
}
