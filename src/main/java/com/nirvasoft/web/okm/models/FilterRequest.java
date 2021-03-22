package com.nirvasoft.web.okm.models;

import java.util.ArrayList;

public class FilterRequest {
    private int start = 0;
    private int end = 0;
    private ArrayList<AdvanceSearchData> filters = new ArrayList<>();

    public int getStart() {
        return start;
    }

    public ArrayList<AdvanceSearchData> getFilters() {
        return filters;
    }

    public void setFilters(ArrayList<AdvanceSearchData> filters) {
        this.filters = filters;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
