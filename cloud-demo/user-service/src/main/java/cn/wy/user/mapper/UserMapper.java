package cn.wy.user.mapper;

import cn.wy.user.entity.User;
import cn.wy.user.utils.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    User queryById(String id);
}
