package com.kaisnm.crewler;

import com.kaisnm.crewler.pipeline.MyConsolePipeline;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;

@TargetUrl("https://github.com/\\w+/\\w+")
@HelpUrl("https://github.com/\\w+")
public class GithubRepo {

    @ExtractBy(value = "//div[@class='crumbs fl']/a[1]/text()", notNull = true)
    private String name;

    @ExtractByUrl("//div[@class='crumbs fl']/a[2]/text()")
    private String author;

    @ExtractBy("//div[@class='crumbs fl']/span[3]/text()")
    private String readme;

    public static void main(String[] args) {

        Spider.create(new GithubRepoPageProcessor()).addPipeline(new MyConsolePipeline())
                .addUrl("http://www.weather.com.cn/weather1d/101210101.shtml")
                .thread(5).run();
//        OOSpider.create(Site.me().setSleepTime(1000)
//                , new ConsolePageModelPipeline(), GithubRepo.class)
//                .addUrl("https://github.com/code4craft").thread(5).run();
    }

    @Override
    public String toString() {
        return "GithubRepo{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", readme='" + readme + '\'' +
                '}';
    }
}
