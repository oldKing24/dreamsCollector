package com.example.demo.utils;

import com.example.demo.Entity.TbCOVIDInfo;
import com.example.demo.Service.IContactactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ServiceUtils {
    @Autowired
    private IContactactService contactService;
    public static ServiceUtils serviceUtils;
    @PostConstruct
    public void init() {
        serviceUtils = this;
        serviceUtils.contactService = this.contactService;
    }

    public void ajaxInsertInfo(TbCOVIDInfo tbCOVIDInfo)throws Exception{
        ajaxdAdd();
        contactService.insertCovidInfo(tbCOVIDInfo);
    }

    public void ajaxdAdd() throws Exception{
        TbCOVIDInfo tbCOVIDInfo = new TbCOVIDInfo();
        contactService.insertCovidInfo(tbCOVIDInfo);
    }
}
