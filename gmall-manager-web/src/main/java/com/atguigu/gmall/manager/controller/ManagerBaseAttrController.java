package com.atguigu.gmall.manager.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.PmsBaseAttrInfo;
import com.atguigu.gmall.bean.PmsBaseAttrValue;
import com.atguigu.gmall.bean.PmsProductSaleAttr;
import com.atguigu.gmall.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class ManagerBaseAttrController {

    @Reference
    ManagerService managerService;

    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id) {

        List<PmsBaseAttrInfo> attrInfoList = managerService.getAttrInfoList(catalog3Id);
        return attrInfoList;
    }

    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public int saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo) {

        Integer num = managerService.saveAttrInfo(pmsBaseAttrInfo);
        System.out.println(pmsBaseAttrInfo + "" + num);

        return num;

    }

    @RequestMapping("getAttrValueList")
    @ResponseBody
    public  List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        List<PmsBaseAttrValue> attrValueList = managerService.getAttrValueList(attrId);
//        System.out.println(pmsBaseAttrInfo+""+num);

        return attrValueList;

    }




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
