package com.fc.test;

import com.fc.controller.UserController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// 代表加载了Spring的容器环境
@SpringBootTest
@RunWith(SpringRunner.class)
class ApplicationTests {

	@Autowired
	private UserController userController;

	@Test
	void contextLoads() {
		userController.test();
	}

}
