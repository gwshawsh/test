package com.hisense.testapp.controller;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320523566722056875
 * @author saasp-de
 * @date today
 */
import com.hisense.testapp.service.AddressService;
import com.hisense.orm.resource.BaseController;
import com.hisense.testapp.pojo.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/address")
public class AddressController extends BaseController<Address>{

    @Autowired
    AddressService addressService;

}
