package com.atguigu.gmall.manager.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.atguigu.gmall.bean.*;
import com.atguigu.gmall.manager.mapper.*;
import com.atguigu.gmall.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;



import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Autowired
    PmsProductInfoMapper pmsProductInfoMapper;

    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    @Autowired
    PmsProductImageMapper pmsProductImageMapper;


    @Override
    public List<PmsBaseCatalog1> getPmsBaseCatalog1() {

        List<PmsBaseCatalog1> pmsBaseCatalog1s = pmsBaseCatalog1Mapper.selectAll();
        return pmsBaseCatalog1s;
    }

    @Override
    public List<PmsBaseCatalog2>  getPmsBaseCatalog2(String catalog1Id) {

        PmsBaseCatalog2 pmsBaseCatalog2 = new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);

        List<PmsBaseCatalog2> pmsBaseCatalog2s = pmsBaseCatalog2Mapper.select(pmsBaseCatalog2);

        return pmsBaseCatalog2s;
    }

    @Override
    public List<PmsBaseCatalog3> getPmsBaseCatalog3(String catalog2Id) {

        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);

        List<PmsBaseCatalog3> pmsBaseCatalog3s = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);

        return pmsBaseCatalog3s;
    }

    @Override
    public  List<PmsBaseAttrInfo> getAttrInfoList(String pmsBaseInfoCatalog3){

        PmsBaseAttrInfo pmsBaseAttrInfo = new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(pmsBaseInfoCatalog3);

        List<PmsBaseAttrInfo> attrInfoList = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);

        return attrInfoList;
    }

    @Override
    public Integer saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {

        int insert1 = pmsBaseAttrInfoMapper.insert(pmsBaseAttrInfo);

        List<PmsBaseAttrValue> attrValueList = pmsBaseAttrInfo.getAttrValueList();

        for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {

            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());

            int insert2 = pmsBaseAttrValueMapper.insert(pmsBaseAttrValue);
        }



//        List<PmsBaseAttrInfo> pmsBaseAttrInfos = pmsBaseAttrInfoMapper.select(pmsBaseAttrInfo);
//
//        for (PmsBaseAttrInfo baseAttrInfo : pmsBaseAttrInfos) {
//            for (PmsBaseAttrValue pmsBaseAttrValue : attrValueList) {
//                pmsBaseAttrValue.setAttrId(baseAttrInfo.getId());
//                int insert2 = pmsBaseAttrValueMapper.insert(pmsBaseAttrValue);
//            }
//
//        }


        return insert1+attrValueList.size();


    }

    @Override
    public  List<PmsBaseAttrValue> getAttrValueList(String attrId) {

        PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue> pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValues;
    }

    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {

        PmsProductInfo pmsProductInfo = new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);

        List<PmsProductInfo> select = pmsProductInfoMapper.select(pmsProductInfo);
        return select;
    }

    @Override
    public Integer savePmsProductInfo(PmsProductInfo pmsProductInfo) {

        int insert = pmsProductInfoMapper.insert(pmsProductInfo);

        for (PmsProductImage spuImage:pmsProductInfo.getSpuImageList()){
            spuImage.setProductId(pmsProductInfo.getId());
            pmsProductImageMapper.insert(spuImage);
        }

        for (PmsProductSaleAttr pmsProductSaleAttr:pmsProductInfo.getSpuSaleAttrList()){
            pmsProductSaleAttr.setProductId(pmsProductInfo.getId());
            pmsProductSaleAttrMapper.insert(pmsProductSaleAttr);

            for (PmsProductSaleAttrValue pmsProductSaleAttrValue :pmsProductSaleAttr.getSpuSaleAttrValueList())
            {
                pmsProductSaleAttrValue.setProductId(pmsProductInfo.getId());
                pmsProductSaleAttrValueMapper.insert(pmsProductSaleAttrValue);
            }

        }


        return insert;
    }

    @Override
    public List<PmsProductSaleAttr> getProductSaleAttrList() {
        return null;
    }

    @Override
    public List<PmsBaseSaleAttr> getPmsBaseSaleAttrList() {

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = pmsBaseSaleAttrMapper.selectAll();

        return pmsBaseSaleAttrs;
    }


}
