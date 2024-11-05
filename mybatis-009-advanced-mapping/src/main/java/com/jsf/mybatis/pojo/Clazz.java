package com.jsf.mybatis.pojo;

import java.util.List;

/**
 * @Description
 * @FileName Clazz
 * @Author JSF
 * @date 2024-11-05
 **/
public class Clazz {
    private Integer cid;
    private String cname;
    private List<Student> stus;

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", stus=" + stus +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    public Clazz(Integer cid, String cname, List<Student> stus) {
        this.cid = cid;
        this.cname = cname;
        this.stus = stus;
    }

    public Clazz() {
    }
}
