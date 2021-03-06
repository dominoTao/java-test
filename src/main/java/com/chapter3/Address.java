package com.chapter3;

import java.io.Serializable;

public class Address implements Serializable {
    private String state;
    private String province;
    private String city;

    public Address(String state, String province, String city) {
        this.state = state;
        this.province = province;
        this.city = city;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(  );
        sb.append("国家："+state+",");
        sb.append("省："+province+",");
        sb.append("市："+city);
        return sb.toString();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
