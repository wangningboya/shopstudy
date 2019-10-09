package cn.wy.user.controller;


import cn.wy.user.entity.User;
import cn.wy.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/queryById")
    public User queryById(
        @RequestParam String id
    ) {
        User user = userService.queryById(id);
        return user;
    }
}
