package com.nydia.druid;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @Description TODO
 * @Date 2021/11/8 12:47
        * @Created by <a href="mailto:nydia_lhq@hotmail.com">lvhuaqiang</a>
        */
@Mapper
public interface UserMapper {
    @Select(value = "select id,name,age from user where id = #{id}")
    User selectUser(Long id);
}
