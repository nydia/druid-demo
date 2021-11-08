package com.nydia.druid;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DruidApplicationTests {
	@Autowired
	UserMapper userMapper;
	@Test
	void contextLoads() {
		User user = userMapper.selectUser(1L);
		System.out.println(user.getName());
	}
}
