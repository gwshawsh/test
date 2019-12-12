package com.hisense.testapp.dao;
    /**
     * @cmptId 1320520990815421099
     * @dmId 1320521384878670507
     * @author saasp-de
     * @date today
     */
import com.hisense.orm.dao.BaseDao;
import com.hisense.testapp.pojo.TestUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface TestUserDao extends BaseDao<TestUser> {
}