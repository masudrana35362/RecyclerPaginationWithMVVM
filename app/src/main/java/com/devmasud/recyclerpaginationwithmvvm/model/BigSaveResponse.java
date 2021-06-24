package com.devmasud.recyclerpaginationwithmvvm.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BigSaveResponse {
    @SerializedName("draw")
    @Expose
    private Integer draw;
    @SerializedName("recordsTotal")
    @Expose
    private Integer recordsTotal;
    @SerializedName("recordsFiltered")
    @Expose
    private Integer recordsFiltered;


    @SerializedName("data")
    @Expose
    private List<BigSaveDataResponse> data = null;


    public BigSaveResponse() {
    }

    public BigSaveResponse(Integer draw, Integer recordsTotal, Integer recordsFiltered, List<BigSaveDataResponse> data) {
        this.draw = draw;
        this.recordsTotal = recordsTotal;
        this.recordsFiltered = recordsFiltered;
        this.data = data;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getRecordsTotal() {
        return recordsTotal;
    }

    public void setRecordsTotal(Integer recordsTotal) {
        this.recordsTotal = recordsTotal;
    }

    public Integer getRecordsFiltered() {
        return recordsFiltered;
    }

    public void setRecordsFiltered(Integer recordsFiltered) {
        this.recordsFiltered = recordsFiltered;
    }

    public List<BigSaveDataResponse> getData() {
        return data;
    }

    public void setData(List<BigSaveDataResponse> data) {
        this.data = data;
    }
}