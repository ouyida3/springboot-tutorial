package com.example.demo.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

    /**
     * 页面请求
     */
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }

    /**
     * 推送数据接口。
     *
     * 样例：http://localhost:8080/checkcenter/socket/push/20?message=test
     *
     * @param cid 客户端的id
     * @param message 推送的消息内容
     * @return
     */
    @ResponseBody
    @RequestMapping("/socket/push/{cid}")
    public String pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
            return cid + "#" + e.getMessage();
        }
        return "id:" + cid;
    }
}
