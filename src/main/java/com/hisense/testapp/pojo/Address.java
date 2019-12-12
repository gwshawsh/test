package com.hisense.testapp.pojo;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320523566722056875
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
@ApiModel(value="address",description="address")
@TbName(name = "address")
public class Address extends Page {

    @ApiModelProperty(value="addressId",name="address_id")
    @TbColumn(column = "address_id"  , isId = true )
    private String addressId;

    @ApiModelProperty(value="enterpriseId",name="enterprise_id")
    @TbColumn(column = "enterprise_id" )
    @NotBlank(message = "enterprise_id不可为空")
    @Length(max = 50,message = "enterprise_id最大长度50")
    private String enterpriseId;

    @ApiModelProperty(value="provinceId",name="province_id")
    @TbColumn(column = "province_id" )
    @NotBlank(message = "province_id不可为空")
    @Length(max = 10,message = "province_id最大长度10")
    private String provinceId;

    @ApiModelProperty(value="cityId",name="city_id")
    @TbColumn(column = "city_id" )
    @NotBlank(message = "city_id不可为空")
    @Length(max = 10,message = "city_id最大长度10")
    private String cityId;

    @ApiModelProperty(value="areaId",name="area_id")
    @TbColumn(column = "area_id" )
    @NotBlank(message = "area_id不可为空")
    @Length(max = 10,message = "area_id最大长度10")
    private String areaId;

    @ApiModelProperty(value="street",name="street")
    @TbColumn(column = "street" )
    @NotBlank(message = "street不可为空")
    @Length(max = 100,message = "street最大长度100")
    private String street;

    @ApiModelProperty(value="postcode",name="postcode")
    @TbColumn(column = "postcode" )
    @NotBlank(message = "postcode不可为空")
    @Length(max = 6,message = "postcode最大长度6")
    private String postcode;

    @ApiModelProperty(value="phone",name="phone")
    @TbColumn(column = "phone" )
    @NotBlank(message = "phone不可为空")
    @Length(max = 15,message = "phone最大长度15")
    private String phone;

    @ApiModelProperty(value="isDef",name="is_def")
    @TbColumn(column = "is_def" )
    @Length(max = 5,message = "is_def最大长度5")
    private String isDef;

    @ApiModelProperty(value="remark",name="remark")
    @TbColumn(column = "remark" )
    @Length(max = 200,message = "remark最大长度200")
    private String remark;

    @ApiModelProperty(value="gmtCreate",name="gmt_create")
    @TbColumn(column = "gmt_create" )
    @Length(max = 19,message = "gmt_create最大长度19")
    private String gmtCreate;

    @ApiModelProperty(value="gmtModified",name="gmt_modified")
    @TbColumn(column = "gmt_modified" )
    @Length(max = 19,message = "gmt_modified最大长度19")
    private String gmtModified;

    @ApiModelProperty(value="createBy",name="create_by")
    @TbColumn(column = "create_by" )
    @Length(max = 50,message = "create_by最大长度50")
    private String createBy;

    @ApiModelProperty(value="modifiedBy",name="modified_by")
    @TbColumn(column = "modified_by" )
    @Length(max = 50,message = "modified_by最大长度50")
    private String modifiedBy;

    @ApiModelProperty(value="name",name="name")
    @TbColumn(column = "name" )
    @Length(max = 255,message = "name最大长度255")
    private String name;
}
