package com.vinhnq.beans;

import io.swagger.models.auth.In;

import java.util.List;
import java.util.Map;

public class DataTableParams {
    private Integer draw = 1;
    private Integer length = 10;
    private Integer start = 0;
    private List<Object> order;
    private List<Object> columns;
    private Map<String, Object> search;

    public DataTableParams() {
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public List<Object> getOrder() {
        return order;
    }

    public void setOrder(List<Object> order) {
        this.order = order;
    }

    public List<Object> getColumns() {
        return columns;
    }

    public void setColumns(List<Object> columns) {
        this.columns = columns;
    }

    public Map<String, Object> getSearch() {
        return search;
    }

    public void setSearch(Map<String, Object> search) {
        this.search = search;
    }
}
