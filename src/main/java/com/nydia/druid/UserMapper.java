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

    String sql1 = "SELECT a.id,a.name \n" +
            "FROM  t_user a \n" +
            "LEFT JOIN t_order b ON b.user_id = a.id\n" +
            "WHERE a.age >= 1\n" +
            "AND a.id = (SELECT user_id FROM t_order WHERE order_no = 'no1')\n" +
            "GROUP BY a.id,a.name\n" +
            "HAVING a.id <> 100\n" +
            "LIMIT 0, 10";

    String sql2 = "select id,name,age from t_user where id = #{id}";

    @Select(value = sql2)
    User selectUser(Long id);

}
