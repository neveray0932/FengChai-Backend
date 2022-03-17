package com.neveray0932.fengchai.common.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author CADTECH
 */
@Data
@ApiModel(description = "Response數據")
public class ResultVO<T> {
    @ApiModelProperty(value = "響應代號")
    private Integer code;
    @ApiModelProperty(value = "響應訊息")
    private String message;
    @ApiModelProperty(value = "響應資料")
    private T data;

    public ResultVO(){

    }

    public ResultVO(Integer code, String msg){
        this.code = code;
        this.message = msg;
    }

    public ResultVO(Integer code, String msg,T data){
        this.code = code;
        this.message = msg;
        this.data = data;
    }
}
