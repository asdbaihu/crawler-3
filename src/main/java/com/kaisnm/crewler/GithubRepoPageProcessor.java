package com.kaisnm.crewler;

import com.alibaba.fastjson.JSON;
import com.kaisnm.crewler.constant.CrawlerConstant;
import com.kaisnm.crewler.model.WeatherDataSK;
import com.kaisnm.crewler.model.WeatherDto;
import com.kaisnm.crewler.pipeline.MyConsolePipeline;
import com.kaisnm.crewler.util.HttpUtil;
import com.kaisnm.crewler.util.ResourceBundleUtil;
import org.apache.commons.lang3.StringUtils;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

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
        System.out.println("当前链接是" + page.getUrl().get());
        try {
//            List<String> all = html.xpath("//div[@class='crumbs fl']/a/text()").all();//获取城市
//            for (String s : all) {
//                System.out.println(s);
//            }
//            Selectable xpath = html.xpath("//div[@class='crumbs fl']/span[3]/text()");
//            System.out.println(xpath.get());
            //列表页匹配列表页 并加入到request link中
//            page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+/\\w+)").all());
//            page.addTargetRequests(page.getHtml().links().regex("(https://github\\.com/\\w+)").all());
            //详情页
            if (page.getUrl().regex("http://www\\.weather\\.com\\.cn/weather1d/\\w+").match()) {
                WeatherDto weatherDto = new WeatherDto();
                weatherDto.setProvince(html.xpath("//div[@class='crumbs fl']/a[1]/text()").toString());//省
                weatherDto.setCity(html.xpath("//div[@class='crumbs fl']/a[2]/text()").toString());//市
                weatherDto.setCounty(html.xpath("//div[@class='crumbs fl']/span[3]/text()").toString());//区
                if (StringUtils.isEmpty(weatherDto.getCity())) {
                    page.setSkip(true);
                } else {
                    //这里模拟请求
                    //var dataSK = {"nameen":"hangzhou","cityname":"杭州","city":"101210101","temp":"12","tempf":"53","WD":"西南风","wde":"SW","WS":"1级","wse":"&lt;12km/h","SD":"74%","time":"20:55","weather":"多云","weathere":"Cloudy","weathercode":"n01","qy":"1019","njd":"8.48km","sd":"74%","rain":"0.0","rain24h":"0","aqi":"86","limitnumber":"不限行","aqi_pm25":"86","date":"11月24日(星期六)"}
                    String result = HttpUtil.doGetWeather(ResourceBundleUtil.getSystem("crawler_details_interface"),
                            "", "", page.getUrl().toString());
                    String[] resultData = result.split(CrawlerConstant.OPERATE_EQUAL);
                    if (resultData.length >= 2) {
                        WeatherDataSK weatherDataSK = JSON.parseObject(resultData[1].trim(), WeatherDataSK.class);
                        weatherDto.setWeatherDataSK(weatherDataSK);
                        page.putField("weatherDto", weatherDto);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Site getSite() {
        return site;
    }

    public static void main(String[] args) throws Exception {

        Spider.create(new GithubRepoPageProcessor()).addPipeline(new MyConsolePipeline())
                .addUrl(ResourceBundleUtil.getSystem("crawler_base_url"))
                .thread(5).run();
    }
}
