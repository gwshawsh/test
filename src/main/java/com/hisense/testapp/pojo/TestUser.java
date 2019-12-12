package com.hisense.testapp.pojo;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320521384878670507
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
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Transient;
import com.hisense.orm.annotation.RelationType;
import java.util.List;


@Getter
@Setter
@ApiModel(value="test_user",description="test_user")
@TbName(name = "test_user")
@Document(collection="test_user")
public class TestUser extends Page {

    @ApiModelProperty(value="userId",name="用户ID")
    @TbColumn(column = "user_id"  , isId = true )
    private String userId;

    @ApiModelProperty(value="userName",name="用户名称")
    @TbColumn(column = "user_name" )
    @NotBlank(message = "用户名称不可为空")
    @Length(max = 50,message = "用户名称最大长度50")
    private String userName;

    @ApiModelProperty(value="createBy",name="创建人")
    @TbColumn(column = "create_by" )
    @NotBlank(message = "创建人不可为空")
    @Length(max = 50,message = "创建人最大长度50")
    private String createBy;

    @ApiModelProperty(value="modifiedBy",name="修改人")
    @TbColumn(column = "modified_by" )
    @NotBlank(message = "修改人不可为空")
    @Length(max = 50,message = "修改人最大长度50")
    private String modifiedBy;

    @ApiModelProperty(value="gmtModified",name="修改时间")
    @TbColumn(column = "gmt_modified" )
    @NotBlank(message = "修改时间不可为空")
    @Length(max = 50,message = "修改时间最大长度50")
    private String gmtModified;

    @ApiModelProperty(value="gmtCreate",name="创建时间")
    @TbColumn(column = "gmt_create" )
    @NotBlank(message = "创建时间不可为空")
    @Length(max = 50,message = "创建时间最大长度50")
    private String gmtCreate;
}
