package com.nirvasoft.web.okm.models;

import java.util.List;

public class CustomerData {
    private String customerId;
    private int customerType;
    private String title;
    private String name;
    private String aliasName;
    private int sex;
    private String dateOfBirth;
    private String nrcNo;
    private String houseNo;
    private String street;
    private String ward;
    private String buildingName;
    private String township;
    private String city;
    private String division;
    private String country;
    private String phone;
    private String email;
    private String fax;
    private String postalCode;
    private String status;
    private String occupation;
    private String fatherName;
    private String universalId;
    private int mStatus;
    private String oldNrcNo;
    private String m1; // Race
    private String m2; // Religion
    private String t2; // User ID
    private String bcNo;
    private String passportNo;
    private String nationalityStatus;
    private String isHasDoc;
    private boolean isSameAddress;
    private String pHouseNo;
    private String pStreet;
    private String pWard;
    private String pTownship;
    private String pCity;
    private String pDivision;
    private String pCountry;
    private String pPostalCode;
    private String registrationDate;
    private String pPhone;
    private String pEmail;
    private String pFax;
    private String pBuildingName;
    private int registerType;
    private String fileName;
    private String photo;
    private List<DocumentData> documents;

    public String getCustomerId() {
        return customerId;
    }

    public List<DocumentData> getDocuments() {
        return documents;
    }

    public void setDocuments(List<DocumentData> documents) {
        this.documents = documents;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getCustomerType() {
        return customerType;
    }

    public void setCustomerType(int customerType) {
        this.customerType = customerType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNrcNo() {
        return nrcNo;
    }

    public void setNrcNo(String nrcNo) {
        this.nrcNo = nrcNo;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getUniversalId() {
        return universalId;
    }

    public void setUniversalId(String universalId) {
        this.universalId = universalId;
    }

    public int getmStatus() {
        return mStatus;
    }

    public void setmStatus(int mStatus) {
        this.mStatus = mStatus;
    }

    public String getOldNrcNo() {
        return oldNrcNo;
    }

    public void setOldNrcNo(String oldNrcNo) {
        this.oldNrcNo = oldNrcNo;
    }

    public String getM1() {
        return m1;
    }

    public void setM1(String m1) {
        this.m1 = m1;
    }

    public String getM2() {
        return m2;
    }

    public void setM2(String m2) {
        this.m2 = m2;
    }

    public String getT2() {
        return t2;
    }

    public void setT2(String t2) {
        this.t2 = t2;
    }

    public String getBcNo() {
        return bcNo;
    }

    public void setBcNo(String bcNo) {
        this.bcNo = bcNo;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getNationalityStatus() {
        return nationalityStatus;
    }

    public void setNationalityStatus(String nationalityStatus) {
        this.nationalityStatus = nationalityStatus;
    }

    public String getIsHasDoc() {
        return isHasDoc;
    }

    public void setIsHasDoc(String isHasDoc) {
        this.isHasDoc = isHasDoc;
    }

    public boolean isSameAddress() {
        return isSameAddress;
    }

    public void setSameAddress(boolean isSameAddress) {
        this.isSameAddress = isSameAddress;
    }

    public String getpHouseNo() {
        return pHouseNo;
    }

    public void setpHouseNo(String pHouseNo) {
        this.pHouseNo = pHouseNo;
    }

    public String getpStreet() {
        return pStreet;
    }

    public void setpStreet(String pStreet) {
        this.pStreet = pStreet;
    }

    public String getpWard() {
        return pWard;
    }

    public void setpWard(String pWard) {
        this.pWard = pWard;
    }

    public String getpTownship() {
        return pTownship;
    }

    public void setpTownship(String pTownship) {
        this.pTownship = pTownship;
    }

    public String getpCity() {
        return pCity;
    }

    public void setpCity(String pCity) {
        this.pCity = pCity;
    }

    public String getpDivision() {
        return pDivision;
    }

    public void setpDivision(String pDivision) {
        this.pDivision = pDivision;
    }

    public String getpCountry() {
        return pCountry;
    }

    public void setpCountry(String pCountry) {
        this.pCountry = pCountry;
    }

    public String getpPostalCode() {
        return pPostalCode;
    }

    public void setpPostalCode(String pPostalCode) {
        this.pPostalCode = pPostalCode;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone;
    }

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getpFax() {
        return pFax;
    }

    public void setpFax(String pFax) {
        this.pFax = pFax;
    }

    public String getpBuildingName() {
        return pBuildingName;
    }

    public void setpBuildingName(String pBuildingName) {
        this.pBuildingName = pBuildingName;
    }

    public int getRegisterType() {
        return registerType;
    }

    public void setRegisterType(int registerType) {
        this.registerType = registerType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
