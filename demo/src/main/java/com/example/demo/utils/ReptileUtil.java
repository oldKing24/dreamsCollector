//package com.example.demo.utils;
//
//import com.alibaba.fastjson.JSON;
//import com.example.demo.Entity.TbCOVIDInfo;
//import com.example.demo.Service.IContactactService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//import us.codecraft.webmagic.Page;
//import us.codecraft.webmagic.Site;
//import us.codecraft.webmagic.Spider;
//import us.codecraft.webmagic.processor.PageProcessor;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import java.time.LocalDateTime;
//import java.util.UUID;
//
//@Component      //1.主要用于标记配置类，兼备Component的效果。
//@EnableScheduling   // 2.开启定时任务
//public class ReptileUtil implements PageProcessor {
////    @Autowired
////    private IContactactService contactService;
//    private IContactactService contactService =(IContactactService)SpringUtil.getBean("contactServiceImpl");
//
//    public static ReptileUtil reptileUtil;
//    @PostConstruct
//    public void init() {
//        reptileUtil = this;
//        reptileUtil.contactService = this.contactService;
//    }
//
//    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
//
//    @Override
//    public void process(Page page){
//        page.putField("name", page.getHtml().xpath("//script[@id='getStatisticsService']").toString());
//        String urls = page.getResultItems().get("name").toString();
//        String[] strs = urls.split("window.getStatisticsService = ");
//        String[] results = strs[1].split("catch");
//        String result = results[0].substring(0,results[0].length()-1);
//        TbCOVIDInfo tbCOVIDInfo = JSON.parseObject(result, TbCOVIDInfo.class);
//        try{
//            tbCOVIDInfo.setMainId(UUID.randomUUID().toString());
//            contactService.insertCovidInfo(tbCOVIDInfo);
////          ServiceUtils serviceUtils = new ServiceUtils();
////          tbCOVIDInfo.setMainId(UUID.randomUUID().toString());
////          serviceUtils.ajaxInsertInfo(tbCOVIDInfo);
//        }catch(Exception e){
//
//        }
//
//    }
//
//    @Bean
//    @Override
//    public Site getSite() {
//        return site;
//    }
//
//    @Bean
//    //3.添加定时任务
//    @Scheduled(cron = "0/5 * * * * ?")
//    //或直接指定时间间隔，例如：5秒
//    //@Scheduled(fixedRate=5000)
//    public void configureTasks() throws Exception{
//        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
//        Spider.create(new ReptileUtil()).addUrl("https://ncov.dxy.cn/ncovh5/view/pneumonia?from=dxy").thread(5).run();
//    }
//
//    public static void main(String[] args) {
//        Spider.create(new ReptileUtil()).addUrl("https://ncov.dxy.cn/ncovh5/view/pneumonia?from=dxy").thread(5).run();
//    }
//}
