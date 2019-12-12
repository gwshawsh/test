package com.hisense.testapp.controller;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320521496547820203
 * @author saasp-de
 * @date today
 */
import com.hisense.testapp.pojo.TestProduct;
import com.hisense.testapp.pojo.ProductIn;
import com.hisense.testapp.service.TestProductService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/testproduct")
public class TestProductController {

    @Autowired
    public TestProductService testProductService;


    @ApiOperation(notes = "模型测试商品表1增加接口",value ="模型测试商品表1增加接口")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object add(@RequestBody  TestProduct clz) {
        return testProductService.addUsedByBase(clz);
    }

    @ApiOperation(notes = "按名称查询商品信息",value ="按名称查询商品信息")
    @RequestMapping(value = "/getbyname", method = RequestMethod.POST)
    public Object getbyname(@RequestBody ProductIn clz) {
        return testProductService.getbyname(clz);
    }
}
