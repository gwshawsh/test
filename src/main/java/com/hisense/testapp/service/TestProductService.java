package com.hisense.testapp.service;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320521496547820203
 * @author saasp-de
 * @date today
 */

import com.alibaba.fastjson.JSONObject;
import com.hisense.orm.annotation.Relation;
import com.hisense.orm.annotation.RelationType;
import com.hisense.orm.dao.BaseDao;
import com.hisense.orm.service.DaoContext;
import com.hisense.orm.sql.TableUtils;
import com.hisense.orm.sql.inf.IOrder;
import com.hisense.testapp.pojo.TestProduct;
import com.hisense.testapp.pojo.ProductIn;
import com.hisense.testapp.dao.TestProductDao;
import com.hisense.bcommon.utils.ConvertObjUtil;
import com.hisense.bcommon.utils.HiWebResult;
import com.hisense.testapp.utils.RestTemplateUtils;
import com.hisense.testapp.utils.OrmUtil;
import com.hisense.testapp.utils.MongoDbUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.hisense.testapp.pojo.QueryAndUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


@Service
public class TestProductService {
    private static final Logger log = LoggerFactory.getLogger(TestProductService.class);

    @Autowired
    TestProductDao testProductDao;
    @Autowired
    OrmUtil ormUtil;
    @Autowired
    RestTemplateUtils restTemplateUtils;
    @Autowired
    MongoTemplate mongoTemplate;


    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public Object addUsedByBase( TestProduct clz) {
        ormUtil.doInsertRelation(clz);
        testProductDao.insertOne(clz);
        return HiWebResult.success(clz);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public Object getbyname(ProductIn clz) {
         TestProduct re = testProductDao.getbyname(String.valueOf(clz.getProductName()));
        return HiWebResult.success(re);
    }
}
