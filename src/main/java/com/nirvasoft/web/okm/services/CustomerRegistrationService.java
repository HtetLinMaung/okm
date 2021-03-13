package com.nirvasoft.web.okm.services;

import java.util.List;

import com.nirvasoft.web.okm.dao.CustomerRegistrationDao;
import com.nirvasoft.web.okm.models.AddressData;
import com.nirvasoft.web.okm.models.ComboData;
import com.nirvasoft.web.okm.models.CountryData;
import com.nirvasoft.web.okm.models.CustomerData;
import com.nirvasoft.web.okm.models.FilterRequest;
import com.nirvasoft.web.okm.models.NameTitleData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CustomerRegistrationService {
    private final CustomerRegistrationDao crDao;

    @Autowired
    public CustomerRegistrationService(@Qualifier("customerRegistrationDao") CustomerRegistrationDao crDao) {
        this.crDao = crDao;
    }

    public int registerCustomer(CustomerData data) {
        return crDao.registerCustomer(data);
    }

    public List<CustomerData> fetchAllCustomers() {
        return crDao.getAllCustomers();
    }

    public List<ComboData> fetchAllCustomerTypes(FilterRequest req) {
        return crDao.getAllCustomerTypes(req);
    }

    public List<ComboData> fetchAllOccupation() {
        return crDao.getAllOccupation();
    }

    public List<NameTitleData> fetchAllNameTitle() {
        return crDao.getAllNameTitle();
    }

    public List<CountryData> fetchAllCountries() {
        return crDao.getAllCountries();
    }

    public List<AddressData> fetchAllAddress() {
        return crDao.getAllAddress();
    }
}
