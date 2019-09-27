package cn.wy.controller;


import cn.wy.entity.User;
import cn.wy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "queryById", method = RequestMethod.POST)
    public User queryById(
        @RequestParam String id
    ) {
        User user = userService.queryById(id);
        return user;
    }
}
