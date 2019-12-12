package com.hisense.testapp.dao;
    /**
     * @cmptId 1320520990815421099
     * @dmId 1320521496547820203
     * @author saasp-de
     * @date today
     */
import com.hisense.orm.dao.BaseDao;
import com.hisense.testapp.pojo.TestProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface TestProductDao extends BaseDao<TestProduct> {
    @Select("select product_id as productId,product_name as productName from test_product where product_name=#{productName}")
    TestProduct getbyname(@Param("productName") String productName);
}