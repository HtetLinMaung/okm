package com.nirvasoft.web.okm.models;

public class NameTitleData {
    private int refNo;
    private String description;
    private int sex;

    public int getRefNo() {
        return refNo;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRefNo(int refNo) {
        this.refNo = refNo;
    }
}
