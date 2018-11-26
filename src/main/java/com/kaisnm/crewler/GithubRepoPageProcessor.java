package com.kaisnm.crewler;

import com.alibaba.fastjson.JSON;
import com.kaisnm.crewler.model.WeatherDataSK;
import com.kaisnm.crewler.model.WeatherDto;
import com.kaisnm.crewler.pipeline.MyConsolePipeline;
import com.kaisnm.crewler.util.HttpUtil;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;
import us.codecraft.webmagic.selector.Selectable;

/**
 * @author: create by jikang.zhou
 * @version: v1.0
 * @description: 爬这和网站http://www.weather.com.cn/weather1d/101210101.shtml
 * @date:2018/11/20
 */
public class GithubRepoPageProcessor implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
    @Override
    public void process(Page page) {
        Html html = page.getHtml();
        try {
//            List<String> all = html.xpath("//div[@class='crumbs fl']/a/text()").all();//获取城市
//            for (String s : all) {
//                System.out.println(s);
//            }
//            Selectable xpath = html.xpath("//div[@class='crumbs fl']/span[3]/text()");
//            System.out.println(xpath.get());
            //列表页

            //详情页
            WeatherDto weatherDto = new WeatherDto();
            weatherDto.setProvince(html.xpath("//div[@class='crumbs fl']/a[1]/text()").toString());//省
            weatherDto.setCity(html.xpath("//div[@class='crumbs fl']/a[2]/text()").toString());//市
            weatherDto.setCounty(html.xpath("//div[@class='crumbs fl']/span[3]/text()").toString());//区
            if(StringUtils.isEmpty(weatherDto.getCity())){
                page.setSkip(true);
            }else {
                //这里模拟请求
                //todo
                String s = HttpUtil.doGetWeather("http://d1.weather.com.cn/sk_2d/101210101.html",
                        "", "122.224.186.251",page.getUrl().toString());
                WeatherDataSK weatherDataSK = JSON.parseObject(s.split("=")[1].trim(), WeatherDataSK.class);
                weatherDto.setWeatherDataSK(weatherDataSK);
                page.putField("weatherDto", weatherDto);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws Exception{

        Spider.create(new GithubRepoPageProcessor()).addPipeline(new MyConsolePipeline())
                .addUrl("http://www.weather.com.cn/weather1d/101210101.shtml")
                .thread(5).run();
    }
}
