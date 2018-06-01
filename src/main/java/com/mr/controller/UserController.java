package com.mr.controller;

import com.mr.model.User;
import com.mr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by ${Gjc} on 2018/6/1.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 测试能否跳转页面
     * @return
     */
    @RequestMapping("/")
    public String toPage(){
        return "index";
    }

    /**
     * 查询
     * @param map
     * @return
     */
    @GetMapping("/user")
    public String userList(ModelMap map){
        List<User> list = userService.userList();
        map.put("list",list);
        return "index";
    }

    /**
     * 跳转新增页面及新增
     * @param
     * @return
     */
    @RequestMapping("addPage")
    public String toAddPage(){
        return "add";
    }

    @PostMapping("/add")
    public String userList(User user){
        userService.addUser(user);
        return "redirect:/user";
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String delUser(@PathVariable("id") Integer id){
        userService.delUser(id);
        return "redirect:/user";
    }

    /**
     * 修改
     * @return
     */
    @RequestMapping("toUpdatePage/{id}")
    public String uId(@PathVariable("id") Integer id,ModelMap map){
        User user = userService.uId(id);
        map.put("user",user);
        return "update";
    }
    @PutMapping("/update")
    public String update(User user){
        userService.update(user);
        return "redirect:/user";
    }
}
