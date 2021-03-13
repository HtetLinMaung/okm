package com.nirvasoft.web.okm.controllers;

import java.util.List;

import com.nirvasoft.web.okm.models.ComboData;
import com.nirvasoft.web.okm.services.InternationalRemittanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/international-remittances")
@CrossOrigin
public class InternationalRemittance {
    private final InternationalRemittanceService irService;

    @Autowired
    public InternationalRemittance(InternationalRemittanceService irService) {
        this.irService = irService;
    }

    @GetMapping(path = "transaction-purposes")
    public List<ComboData> getAllTransactionPurposes() {
        return irService.fetchAllTransactionPurposes();
    }

    @GetMapping(path = "payment-methods")
    public List<ComboData> getAllPaymentMethods() {
        return irService.fetchAllPaymentMethods();
    }

    @GetMapping(path = "collection-methods")
    public List<ComboData> getAllCollectionMethods() {
        return irService.fetchAllCollectionMethods();
    }
}
