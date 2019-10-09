package cn.wy.consumer.web;


import cn.wy.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/queryById")
    public User queryById(
        @RequestParam String id
    ) {
        String url = "http://localhost:8081/user/queryById?id="+id;
        User user = restTemplate.getForObject(url,User.class);
        return user;
    }
}
