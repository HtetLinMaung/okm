package com.nirvasoft.web.okm.services;

import java.util.List;

import com.nirvasoft.web.okm.dao.InternationalRemittanceDao;
import com.nirvasoft.web.okm.models.ComboData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InternationalRemittanceService {
    private final InternationalRemittanceDao irDao;

    @Autowired
    public InternationalRemittanceService(@Qualifier("internationalRemittanceDao") InternationalRemittanceDao irDao) {
        this.irDao = irDao;
    }

    public List<ComboData> fetchAllTransactionPurposes() {
        return irDao.getAllTransactionPurposes();
    }

    public List<ComboData> fetchAllPaymentMethods() {
        return irDao.getAllPaymentMethods();
    }

    public List<ComboData> fetchAllCollectionMethods() {
        return irDao.getAllCollectionMethods();
    }
}
