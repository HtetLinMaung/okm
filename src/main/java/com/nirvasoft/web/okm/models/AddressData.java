package com.nirvasoft.web.okm.models;

public class AddressData {
    private String code;
    private String descMyan;
    private String descEng;
    private boolean local;

    public boolean isLocal() {
        return local;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescMyan() {
        return descMyan;
    }

    public void setDescMyan(String descMyan) {
        this.descMyan = descMyan;
    }

    public String getDescEng() {
        return descEng;
    }

    public void setDescEng(String descEng) {
        this.descEng = descEng;
    }

    public void setLocal(boolean local) {
        this.local = local;
    }
}
