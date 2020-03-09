package com.atguigu.gmall.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseCatalog1;
import com.atguigu.gmall.bean.PmsBaseCatalog2;
import com.atguigu.gmall.bean.PmsBaseCatalog3;
import com.atguigu.gmall.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class ManagerCatalogController {

    @Reference
    ManagerService managerService;

    @RequestMapping("getCatalog1")
    @ResponseBody
    public  List<PmsBaseCatalog1> getCatalog1(){

        List<PmsBaseCatalog1> pmsBaseCatalog1 =managerService.getPmsBaseCatalog1();
        return pmsBaseCatalog1;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public  List<PmsBaseCatalog2> getCatalog2(String catalog1Id){

        List<PmsBaseCatalog2> pmsBaseCatalog2 =managerService.getPmsBaseCatalog2(catalog1Id);
        return pmsBaseCatalog2;
    }

    @RequestMapping("getCatalog3")
    @ResponseBody
    public  List<PmsBaseCatalog3> getCatalog3(String catalog2Id){

        List<PmsBaseCatalog3> pmsBaseCatalog3 =managerService.getPmsBaseCatalog3(catalog2Id);
        return pmsBaseCatalog3;
    }


}
