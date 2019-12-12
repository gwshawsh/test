package com.hisense.testapp.controller;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320521384878670507
 * @author saasp-de
 * @date today
 */
import com.hisense.testapp.pojo.TestUser;
import com.hisense.testapp.service.TestUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/testuser")
public class TestUserController {

    @Autowired
    public TestUserService testUserService;


    @ApiOperation(notes = "模型测试用户表1增加接口",value ="模型测试用户表1增加接口")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody  TestUser clz) {
        return testUserService.addUsedByBase(clz);
    }
}
