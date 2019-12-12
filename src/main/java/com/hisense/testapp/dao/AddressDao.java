package com.hisense.testapp.dao;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320523566722056875
 * @author saasp-de
 * @date today
 */
import com.hisense.orm.dao.BaseDao;
import com.hisense.testapp.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AddressDao extends BaseDao<Address> {
}