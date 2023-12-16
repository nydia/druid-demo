package com.nydia.druid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DruidStatController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/insertdata")
    public Object insertdata(){
        User user = userMapper.selectUser(1L);
        System.out.println(">>>>>>>>>>>>> " + user.getName());
        return user;
    }

    @GetMapping("/druid/stat")
    public Object druidStat(){
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        //return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
        return null;
    }



}