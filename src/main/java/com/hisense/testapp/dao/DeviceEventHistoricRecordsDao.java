package com.hisense.testapp.dao;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320529574307561720
 * @author saasp-de
 * @date today
 */
import com.hisense.orm.dao.BaseDao;
import com.hisense.testapp.pojo.DeviceEventHistoricRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeviceEventHistoricRecordsDao extends BaseDao<DeviceEventHistoricRecords> {
}