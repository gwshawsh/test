package com.hisense.testapp.controller;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320529574307561720
 * @author saasp-de
 * @date today
 */
import com.hisense.testapp.service.DeviceEventHistoricRecordsService;
import com.hisense.orm.resource.BaseController;
import com.hisense.testapp.pojo.DeviceEventHistoricRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/deviceeventhistoricrecords")
public class DeviceEventHistoricRecordsController extends BaseController<DeviceEventHistoricRecords>{

    @Autowired
    DeviceEventHistoricRecordsService deviceEventHistoricRecordsService;

}
