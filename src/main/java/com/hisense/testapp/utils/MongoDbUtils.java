package com.hisense.testapp.utils;
/*
* hxh
* today
*/
import com.hisense.orm.annotation.TbColumn;
import com.hisense.orm.annotation.TbId;
import com.hisense.testapp.pojo.QueryAndUpdate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by user on 2019/8/12.
 */
public class MongoDbUtils {

    public static <T> Query getQueryByObject(T object) {
        Query query = new Query();
        String[] fileds = getFiledName(object);
        Criteria criteria = new Criteria();
        for (int i = 0; i < fileds.length; i++) {
            String filedName = (String) fileds[i];
            Object filedValue = getFieldValueByName(filedName, object);
            if (filedValue != null) {
                criteria.and(filedName).is(filedValue);
            }
        }
        query.addCriteria(criteria);
        return query;
    }

    private static String[] getFiledName(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        String[] fieldNames = new String[fields.length];

        for (int i = 0; i < fields.length; ++i) {
            fieldNames[i] = fields[i].getName();
        }

        return fieldNames;
    }

    private static Object getFieldValueByName(String fieldName, Object o) {
        try {
            String e = fieldName.substring(0, 1).toUpperCase();
            String getter = "get" + e + fieldName.substring(1);
            Method method = o.getClass().getMethod(getter, new Class[0]);
            return method.invoke(o, new Object[0]);
        } catch (Exception var6) {
            return null;
        }
    }

    public static <T> QueryAndUpdate getUpdateAndWhere(T obj) {
        QueryAndUpdate queryAndUpdate = new QueryAndUpdate();
        Query query = new Query();
        Criteria criteria = new Criteria();
        Update update = new Update();
        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                // hisense-orm 注解
                if (field.isAnnotationPresent(TbId.class) && field.get(obj) != null) {
                    criteria.and(field.getName()).is(getFieldValueByName(field.getName(), obj));
                    continue;
                }

                if (field.isAnnotationPresent(TbColumn.class) && field.get(obj) != null) {
                    TbColumn fieldAnno = (TbColumn) field.getAnnotation(TbColumn.class);
                    if (fieldAnno.isId()) {
                        criteria.and(field.getName()).is(getFieldValueByName(field.getName(), obj));
                        continue;
                    } else {
                        update.set(field.getName(), getFieldValueByName(field.getName(), obj));
                        continue;
                    }
                }
            }
        } catch (IllegalAccessException ex) {
            throw new RuntimeException("mongodb查询条件构建错误");
        }
        queryAndUpdate.setQuery(query.addCriteria(criteria));
        queryAndUpdate.setUpdate(update);
        return queryAndUpdate;
    }

    public static <T> Query getPageQueryOrm(T object) {
        Query query = new Query();
        String[] fileds = getFiledName(object);
        Criteria criteria = new Criteria();
        for (int i = 0; i < fileds.length; i++) {
            String filedName = (String) fileds[i];
            Object filedValue = getFieldValueByName(filedName, object);
            if (StringUtils.equals(filedName, "pageSize") && filedValue != null) {
                query.limit(Integer.parseInt(String.valueOf(filedValue)));
            } else if (StringUtils.equals(filedName, "pageNo") && filedValue != null) {
                query.skip(Integer.parseInt(String.valueOf(filedValue)));
            } else if (filedValue != null) {
                criteria.and(filedName).is(filedValue);
            }
        }
        query.addCriteria(criteria);
        return query;
    }

    public static <T> Query getPageQueryMp(T object, String pageNo, String pageSize) {
        Query query = new Query();
        String[] fileds = getFiledName(object);
        Criteria criteria = new Criteria();
        for (int i = 0; i < fileds.length; i++) {
            String filedName = (String) fileds[i];
            Object filedValue = getFieldValueByName(filedName, object);
            criteria.and(filedName).is(filedValue);
        }
        if (StringUtils.isNotEmpty(pageNo)) {
            query.skip(Integer.parseInt(pageNo));
        }
        if (StringUtils.isNotEmpty(pageSize)) {
            query.limit(Integer.parseInt(pageSize));
        }
        query.addCriteria(criteria);
        return query;
    }
}

