package cn.wy.consumer.web;


import cn.wy.consumer.client.UserClient;
import cn.wy.consumer.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "/consumer")
@DefaultProperties(defaultFallback = "allFallBack")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserClient userClient;

//    @Autowired
//    private RibbonLoadBalancerClient client;

    @GetMapping(value = "/queryById")
//    @HystrixCommand(fallbackMethod = "queryByIdFallBack")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public User queryById(
            @RequestParam String id
    ) {
        // 根据服务id获取实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        // 从实例中取出ip和端口
//        ServiceInstance serviceInstance = instances.get(0);

        // 随机 轮询 hash
//        ServiceInstance instance = client.choose("user-service");

//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/queryById?id=" + id;

//        String url = "http://user-service/user/queryById?id=" + id;
//        User user = restTemplate.getForObject(url, User.class);
        User user = userClient.queryById(id);
        return user;
    }

    /**
     * 失败调用方法
     * 返回值和参数必须一致
     *
     * @param id
     * @return
     */
    public User queryByIdFallBack(
            String id
    ) {
        User user = new User();
        return user;
    }

    /**
     * 全局统一失败调用方法
     * 不能有参数
     * @return
     */
    public User allFallBack(
    ) {
        User user = new User();
        return user;
    }
}
