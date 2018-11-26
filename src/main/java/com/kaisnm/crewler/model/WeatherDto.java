package com.kaisnm.crewler.model;

import java.io.Serializable;

/**
 * @author: create by jikang.zhou
 * @version: v1.0
 * @description: com.kaisnm.crewler.model
 * @date:2018/11/24
 */
public class WeatherDto implements Serializable {

    private String province;

    private String city;

    private String county;

    private WeatherDataSK weatherDataSK;

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

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public WeatherDataSK getWeatherDataSK() {
        return weatherDataSK;
    }

    public void setWeatherDataSK(WeatherDataSK weatherDataSK) {
        this.weatherDataSK = weatherDataSK;
    }

    @Override
    public String toString() {
        return "WeatherDto{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", weatherDataSK=" + weatherDataSK +
                '}';
    }
}
