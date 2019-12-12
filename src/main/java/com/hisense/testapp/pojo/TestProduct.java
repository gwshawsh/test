package com.hisense.testapp.pojo;
/**
 * @cmptId 1320520990815421099
 * @dmId 1320521496547820203
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
@ApiModel(value="test_product",description="test_product")
@TbName(name = "test_product")
@Document(collection="test_product")
public class TestProduct extends Page {

    @ApiModelProperty(value="productId",name="商品ID")
    @TbColumn(column = "product_id"  , isId = true )
    private String productId;

    @ApiModelProperty(value="productName",name="商品名称")
    @TbColumn(column = "product_name" )
    @NotBlank(message = "商品名称不可为空")
    @Length(max = 50,message = "商品名称最大长度50")
    private String productName;

    @ApiModelProperty(value="price",name="商品价格")
    @TbColumn(column = "price" )
    @NotBlank(message = "商品价格不可为空")
    @Length(max = 50,message = "商品价格最大长度50")
    private String price;

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

    @ApiModelProperty(value="gmtCreate",name="创建时间")
    @TbColumn(column = "gmt_create" )
    @NotBlank(message = "创建时间不可为空")
    @Length(max = 50,message = "创建时间最大长度50")
    private String gmtCreate;

    @ApiModelProperty(value="gmtModified",name="修改时间")
    @TbColumn(column = "gmt_modified" )
    @NotBlank(message = "修改时间不可为空")
    @Length(max = 50,message = "修改时间最大长度50")
    private String gmtModified;
}
