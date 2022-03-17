package com.neveray0932.fengchai.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.neveray0932.fengchai.common.Vo.ApiMsg;
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
@ApiModel(value = "Depository對象", description = ApiMsg.API_DESCRIPTION)
public class Depository {

    @TableId(value = "dep_id", type = IdType.AUTO)
    @ApiModelProperty(value = "倉庫別編號",required = true)
    private Integer depId;
    @ApiModelProperty(value = "倉庫別名稱")
    private String depName;


}
