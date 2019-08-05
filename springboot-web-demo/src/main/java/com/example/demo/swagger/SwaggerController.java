package com.example.demo.swagger;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Unable to infer base url.
 * This is common when using dynamic servlet registration or when the API is behind an API Gateway.
 * The base url is the root of where all the swagger resources are served.
 * For e.g. if the api is available at http://example.org/api/v2/api-docs then the base url is
 * http://example.org/api/. Please enter the location manually:
 * 升级版本到2.7.0（旧界面）或2.9.2（新界面）解决。
 * 不使用2.6.1版本（原因未查明）
 *
 * 界面：
 * http://localhost:8080/swagger-ui.html
 *
 * json串：
 * http://localhost:8080/v2/api-docs
 */
@RestController
@Api(value = "Swagger控制器", tags = {"Swagger接口"})
public class SwaggerController {

    @GetMapping(value = "/get")
    @ApiOperation(value = "get操作", notes = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "src",
                    value = "开始节点",
                    required = true, // 默认为false
                    paramType = "query",
                    defaultValue = "1234500100001000",
                    dataType = "String"
            )
    })
    public void get(String src, String dest) {

    }

    @PostMapping(value = "/post")
    @ApiOperation(value = "post操作", notes = "POST")
    @ApiImplicitParams({@ApiImplicitParam(
            name = "req", value = "请求入参对象", required = true,
            dataType = "SwaggerReq"// @ApiImplicitParam里必须指定，否则使用默认的String；如不使用ApiImplicitParam，则自动匹配入参类
    )})
    public void post(@RequestBody SwaggerReq req) {

    }

}
