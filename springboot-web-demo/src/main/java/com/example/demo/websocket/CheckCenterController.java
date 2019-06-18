package com.example.demo.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

    /**
     * 推送数据接口。
     *
     * 样例：
     * 推送单个电视：http://localhost:8080/checkcenter/socket/push/20?message=notice
     * 推送全部电视：http://localhost:8080/checkcenter/socket/push/all?message=notice
     *
     * @param cid 客户端的id
     * @param message 推送的消息内容
     * @return json字符串，包含客户端的id与消息内容或异常内容
     */
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public String pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
            return "{id:" + cid + ", error:" + e.getMessage() + "}";
        }
        return "{id:" + cid + ", message:" + message + "}";
    }
}
