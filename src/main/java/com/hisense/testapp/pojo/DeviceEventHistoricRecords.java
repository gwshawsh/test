package com.hisense.testapp.pojo;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320529574307561720
 * @author saasp-de
 * @date today
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
import com.hisense.orm.sql.Page;
import com.hisense.orm.sql.BaseTable;
import com.hisense.orm.annotation.TbColumn;
import com.hisense.orm.annotation.TbName;
import com.hisense.orm.annotation.RefColumn;
import com.hisense.orm.annotation.Relation;
import com.hisense.orm.annotation.RelationType;
import java.util.List;

@Getter
@Setter
@ApiModel(value="device_event_historic_records",description="device_event_historic_records")
@TbName(name = "device_event_historic_records")
public class DeviceEventHistoricRecords extends Page {

    @ApiModelProperty(value="deviceId",name="设备ID")
    @TbColumn(column = "device_id" )
    @Length(max = 32,message = "设备ID最大长度32")
    private String deviceId;

    @ApiModelProperty(value="identifier",name="事件标识符")
    @TbColumn(column = "identifier" )
    @Length(max = 50,message = "事件标识符最大长度50")
    private String identifier;

    @ApiModelProperty(value="eventName",name="事件名称")
    @TbColumn(column = "event_name" )
    @Length(max = 50,message = "事件名称最大长度50")
    private String eventName;

    @ApiModelProperty(value="eventType",name="事件类型")
    @TbColumn(column = "event_type" )
    @Length(max = 50,message = "事件类型最大长度50")
    private String eventType;

    @ApiModelProperty(value="outParam",name="输出参数")
    @TbColumn(column = "out_param" )
    @Length(max = ,message = "输出参数最大长度")
    private String outParam;

    @ApiModelProperty(value="gmtCreate",name="创建时间")
    @TbColumn(column = "gmt_create" )
    @Length(max = ,message = "创建时间最大长度")
    private String gmtCreate;

    @ApiModelProperty(value="gmtModified",name="修改时间")
    @TbColumn(column = "gmt_modified" )
    @Length(max = ,message = "修改时间最大长度")
    private String gmtModified;

    @TbColumn(column = "tenant_id" )
    private String tenantId;
}
