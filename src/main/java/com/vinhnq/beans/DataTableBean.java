package com.vinhnq.beans;

public class DataTableBean<T> {
    private Integer draw = 1;
    private Integer recordsTotal = 0;
    private Integer recordsFiltered = 0;
    private T data;

    public DataTableBean() {
    }

    public DataTableBean(T data) {
        this.data = data;
    }

    public DataTableBean(Integer draw, Integer recordsTotal, Integer recordsFiltered, T data) {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
