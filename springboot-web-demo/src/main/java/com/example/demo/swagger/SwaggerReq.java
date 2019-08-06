package com.example.demo.swagger;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class SwaggerReq {
    @ApiModelProperty(value = "通行id", name = "passId", position = 1, dataType = "String", example = "20190723161423", required = true)
    private String passId;

    @ApiModelProperty(allowableValues = "1234500100001000, 1234500100001210, 1234500100000600", value = "收费单元编号", hidden = true)
    private String tollIntervalId;// 如果通行则不为空；如果是拟合请求则为空

    @ApiModelProperty(value = "时间", hidden = true)
    private LocalDateTime time;// 如果是通行，则是通行时间；如果是拟合，则是当前拟合请求的时间

    @ApiModelProperty(position = 4, example = "2", allowableValues = "range[1, 10)")
    private Integer version;// 版本号，目前用不到

    @ApiModelProperty(value = "节点数组", name = "path", position = 5, dataType = "List", example = "[1234507400000300,1234507400000510,1234507400009230]")
    private List<String> path;
}
