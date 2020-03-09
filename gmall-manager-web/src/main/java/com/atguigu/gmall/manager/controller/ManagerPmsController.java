package com.atguigu.gmall.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manager.pmsUtils.PmsUpload;
import com.atguigu.gmall.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Scanner;

@Controller
@CrossOrigin
public class ManagerPmsController {

    @Reference
    ManagerService managerService;

    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> getAttrInfoList(String catalog3Id) {

        List<PmsProductInfo> attrInfoList = managerService.getSpuList(catalog3Id);
        return attrInfoList;
    }

    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public int saveAttrInfo(@RequestBody PmsProductInfo pmsProductInfo) {

        Integer num = managerService.savePmsProductInfo(pmsProductInfo);
        System.out.println(pmsProductInfo + "" + num);

        return num;

    }

    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> getBaseSaleAttrList(){
        List<PmsBaseSaleAttr> pmsPmsBaseSaleAttrs= managerService.getPmsBaseSaleAttrList();

        return pmsPmsBaseSaleAttrs;


    }

    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        String imgUrl;
        imgUrl = PmsUpload.fileUpload(multipartFile);

        return imgUrl;


    }



//
//    @RequestMapping("getAttrValueList")
//    @ResponseBody
//    public  List<PmsBaseAttrValue> getAttrValueList(String attrId) {
//
//        List<PmsBaseAttrValue> attrValueList = managerService.getAttrValueList(attrId);
////        System.out.println(pmsBaseAttrInfo+""+num);
//
//        return attrValueList;
//
//    }


//    @RequestMapping("getCatalog2")
//    @ResponseBody
//    public  List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
//
//        List<PmsBaseCatalog2> pmsBaseCatalog2 =managerService.getPmsBaseCatalog2(catalog1Id);
//        return pmsBaseCatalog2;
//    }
//
//    @RequestMapping("getCatalog3")
//    @ResponseBody
//    public  List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
//
//        List<PmsBaseCatalog3> pmsBaseCatalog3 =managerService.getPmsBaseCatalog3(catalog2Id);
//        return pmsBaseCatalog3;
//    }


}
