package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.neveray0932.fengchai.common.vo.ApiMsg;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Andy
 * @since 2022-03-10
 */
@Getter
@Setter
@Data
@TableName("product_unit")
@ApiModel(value = "ProductUnit對象", description = ApiMsg.API_DESCRIPTION)
public class ProductUnit {

    @TableId(value = "punit_id", type = IdType.AUTO)
    @ApiModelProperty(value = "產品單位編號",required = true)
    private Integer punitId;
    @ApiModelProperty(value = "產品單位名稱")
    private String punitName;


}
