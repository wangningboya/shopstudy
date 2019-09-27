package cn.wy.mapper;

import cn.wy.entity.User;
import cn.wy.utils.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    User queryById(String id);
}
