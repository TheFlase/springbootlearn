package com.wgc.learn.controller;

import com.wgc.learn.common.AppException;
import com.wgc.learn.model.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 8/11/2018.
 */

@RestController
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping
    public String index() {
        return "hello world!";
    }

    @RequestMapping(value = "/get")
    public Map<String, Object> get(@RequestParam String name) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title", "hello test");
        map.put("name", name);
        return map;
    }

    // @PathVariable 获得请求url中的动态参数
    @RequestMapping(value = "/get/{id}/{name}")
    public User getUser(@PathVariable int id, @PathVariable String name) {
        User user = new User();
        user.setId(id);
        user.setName(name);
        return user;
    }

    /**
     * 测试返回异常页面-page
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/hello")
    public String testErrorPage() throws Exception {
        throw new Exception("发生错误");
    }

    /**
     * 测试返回异常-json
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/json")
    public String testErrorJson() throws Exception {
        throw new AppException("发生错误");
    }

}
