package com.nirvasoft.web.okm.controllers;

import java.util.List;

import com.nirvasoft.web.okm.models.ComboData;
import com.nirvasoft.web.okm.models.RemitOutData;
import com.nirvasoft.web.okm.models.ResponseData;
import com.nirvasoft.web.okm.services.InternationalRemittanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping(path = "send-money")
    public ResponseEntity<ResponseData> sendMoney(@RequestBody RemitOutData data) {
        ResponseData res = new ResponseData();
        int success = irService.sendMoney(data);

        if (success == 1) {
            res.setMessage("Send money successful");
        } else {
            res.setMessage("Something went wrong");
        }

        return ResponseEntity.status(201).body(res);
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

    @GetMapping(path = "wallet-types")
    public List<ComboData> getAllWalletTypes() {
        return irService.fetchAllWalletTypes();
    }
}
