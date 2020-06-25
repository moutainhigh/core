package com.gupaoedu.example.project.dao.mappers;

import com.gupaoedu.example.project.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 咕泡学院，只为更好的你
 * 咕泡学院-Mic: 2227324689
 * http://www.gupaoedu.com
 **/
@Mapper
public interface UserMapper {

    int insert(User user);
}
