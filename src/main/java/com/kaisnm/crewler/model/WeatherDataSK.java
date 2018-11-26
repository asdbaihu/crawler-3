package com.kaisnm.crewler.model;

/**
 * @author: create by jikang.zhou
 * @version: v1.0
 * @description: 当天杭州的天气
 * @date:2018/11/24
 */
//var dataSK = {"nameen":"hangzhou","cityname":"杭州","city":"101210101","temp":"12","tempf":"53","WD":"西南风","wde":"SW","WS":"1级","wse":"&lt;12km/h","SD":"74%","time":"20:55","weather":"多云","weathere":"Cloudy","weathercode":"n01","qy":"1019","njd":"8.48km","sd":"74%","rain":"0.0","rain24h":"0","aqi":"86","limitnumber":"不限行","aqi_pm25":"86","date":"11月24日(星期六)"}
public class WeatherDataSK {

    private String nameen;

    private String cityname;

    private String city;

    private String temp;

    private String tempf;

    private String WD;

    private String wde;

    private String WS;

    private String wse;

    private String SD;

    private String time;

    private String weather;

    private String weathere;

    private String weathercode;

    private String qy;

    private String njd;

    private String sd;

    private String rain;

    private String rain24h;

    private String aqi;

    private String limitnumber;

    private String aqi_pm25;

    private String date;

    public String getNameen() {
        return nameen;
    }

    public void setNameen(String nameen) {
        this.nameen = nameen;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getTempf() {
        return tempf;
    }

    public void setTempf(String tempf) {
        this.tempf = tempf;
    }

    public String getWD() {
        return WD;
    }

    public void setWD(String WD) {
        this.WD = WD;
    }

    public String getWde() {
        return wde;
    }

    public void setWde(String wde) {
        this.wde = wde;
    }

    public String getWS() {
        return WS;
    }

    public void setWS(String WS) {
        this.WS = WS;
    }

    public String getWse() {
        return wse;
    }

    public void setWse(String wse) {
        this.wse = wse;
    }

    public String getSD() {
        return SD;
    }

    public void setSD(String SD) {
        this.SD = SD;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWeathere() {
        return weathere;
    }

    public void setWeathere(String weathere) {
        this.weathere = weathere;
    }

    public String getWeathercode() {
        return weathercode;
    }

    public void setWeathercode(String weathercode) {
        this.weathercode = weathercode;
    }

    public String getQy() {
        return qy;
    }

    public void setQy(String qy) {
        this.qy = qy;
    }

    public String getNjd() {
        return njd;
    }

    public void setNjd(String njd) {
        this.njd = njd;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getRain24h() {
        return rain24h;
    }

    public void setRain24h(String rain24h) {
        this.rain24h = rain24h;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getLimitnumber() {
        return limitnumber;
    }

    public void setLimitnumber(String limitnumber) {
        this.limitnumber = limitnumber;
    }

    public String getAqi_pm25() {
        return aqi_pm25;
    }

    public void setAqi_pm25(String aqi_pm25) {
        this.aqi_pm25 = aqi_pm25;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "WeatherDataSK{" +
                "nameen='" + nameen + '\'' +
                ", cityname='" + cityname + '\'' +
                ", city='" + city + '\'' +
                ", temp='" + temp + '\'' +
                ", tempf='" + tempf + '\'' +
                ", WD='" + WD + '\'' +
                ", wde='" + wde + '\'' +
                ", WS='" + WS + '\'' +
                ", wse='" + wse + '\'' +
                ", SD='" + SD + '\'' +
                ", time='" + time + '\'' +
                ", weather='" + weather + '\'' +
                ", weathere='" + weathere + '\'' +
                ", weathercode='" + weathercode + '\'' +
                ", qy='" + qy + '\'' +
                ", njd='" + njd + '\'' +
                ", sd='" + sd + '\'' +
                ", rain='" + rain + '\'' +
                ", rain24h='" + rain24h + '\'' +
                ", aqi='" + aqi + '\'' +
                ", limitnumber='" + limitnumber + '\'' +
                ", aqi_pm25='" + aqi_pm25 + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
