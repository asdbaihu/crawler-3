package com.kaisnm.crewler.util;

import com.alibaba.fastjson.JSON;
import com.kaisnm.crewler.model.WeatherDataSK;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {

	public static String doGetWeather(String url, String param,String ip,String referer) throws Exception{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet;
		if(StringUtils.isNotBlank(param)){
			httpGet = new HttpGet(url+"?"+param);
		}else {
			httpGet = new HttpGet(url);
		}
		httpGet.addHeader("accept", "*/*");
		httpGet.addHeader("connection", "Keep-Alive");
		httpGet.addHeader("Host","d1.weather.com.cn");
		httpGet.addHeader("Pragma","no-cache");
		httpGet.addHeader("Referer",referer);
		httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36");
		if(StringUtils.isNotBlank(ip)){
			httpGet.addHeader("X-Forwarded-For", ip);
			httpGet.addHeader("HTTP_X_FORWARDED_FOR", ip);
			httpGet.addHeader("HTTP_CLIENT_IP", ip);
			httpGet.addHeader("REMOTE_ADDR", ip);
		}
		// 超时时间设置
		// 发送请求
		CloseableHttpResponse response = httpclient.execute(httpGet);

		// 获取返回内容
		try {
			HttpEntity entity = response.getEntity();
			String strResult = EntityUtils.toString(entity,"UTF-8");
			System.out.println(strResult);
			return strResult;
		} finally {
			response.close();
		}

	}

	public static void main(String[] args) throws Exception{
		String s = doGetWeather("http://d1.weather.com.cn/sk_2d/101210101.html","","122.224.186.251","http://www.weather.com.cn/weather1d/101210101.shtml");
		System.out.println(s.split("=")[1].trim());

		WeatherDataSK weatherDataSK = JSON.parseObject(s.split("=")[1].trim(), WeatherDataSK.class);
		System.out.println(weatherDataSK.toString());
	}
}