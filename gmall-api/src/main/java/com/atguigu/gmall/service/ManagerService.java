package com.atguigu.gmall.service;

import com.atguigu.gmall.bean.*;

import java.util.List;

public interface ManagerService {

    List<PmsBaseCatalog1> getPmsBaseCatalog1();

    List<PmsBaseCatalog2> getPmsBaseCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getPmsBaseCatalog3(String catalog2Id);

    List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id);

    Integer saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsProductInfo> getSpuList(String catalog3Id);

    Integer savePmsProductInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> getProductSaleAttrList();

    List<PmsBaseSaleAttr> getPmsBaseSaleAttrList();


}
