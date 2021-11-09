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

    String sql = "SELECT a.id,a.name \n" +
            "FROM  USER a \n" +
            "LEFT JOIN td_order b ON b.user_id = a.id\n" +
            "WHERE a.age >= 1\n" +
            "AND a.id = (SELECT user_id FROM td_order WHERE order_no = 'no1')\n" +
            "GROUP BY a.id,a.name\n" +
            "HAVING a.id <> 100\n" +
            "LIMIT 0, 10";

    //@Select(value = "select id,name,age from user where id = #{id}")
    @Select(value = sql)
    User selectUser(Long id);

}
