package com.vinhnq.beans;

import java.sql.Timestamp;

public class ImportAPIBean {
    private Timestamp sagyoDate;
    private String bkn09;
    private String buzaiKigo;
    private String zaisitu;
    private String kakoMongon;
    private String dansunMongon;
    private Integer nagasa;
    private Integer zaikoInzu;
    private String sojoNo;
    private String szNo;
    private Integer status;

    public ImportAPIBean() {
    }

    public Timestamp getSagyoDate() {
        return sagyoDate;
    }

    public void setSagyoDate(Timestamp sagyoDate) {
        this.sagyoDate = sagyoDate;
    }

    public String getBkn09() {
        return bkn09;
    }

    public void setBkn09(String bkn09) {
        this.bkn09 = bkn09;
    }

    public String getBuzaiKigo() {
        return buzaiKigo;
    }

    public void setBuzaiKigo(String buzaiKigo) {
        this.buzaiKigo = buzaiKigo;
    }

    public String getZaisitu() {
        return zaisitu;
    }

    public void setZaisitu(String zaisitu) {
        this.zaisitu = zaisitu;
    }

    public String getDansunMongon() {
        return dansunMongon;
    }

    public void setDansunMongon(String dansunMongon) {
        this.dansunMongon = dansunMongon;
    }

    public Integer getNagasa() {
        return nagasa;
    }

    public void setNagasa(Integer nagasa) {
        this.nagasa = nagasa;
    }

    public Integer getZaikoInzu() {
        return zaikoInzu;
    }

    public void setZaikoInzu(Integer zaikoInzu) {
        this.zaikoInzu = zaikoInzu;
    }

    public String getSzNo() {
        return szNo;
    }

    public void setSzNo(String szNo) {
        this.szNo = szNo;
    }

    public String getSojoNo() {
        return sojoNo;
    }

    public void setSojoNo(String sojoNo) {
        this.sojoNo = sojoNo;
    }

    public String getKakoMongon() {
        return kakoMongon;
    }

    public void setKakoMongon(String kakoMongon) {
        this.kakoMongon = kakoMongon;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
