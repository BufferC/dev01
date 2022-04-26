package com.fc;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@DisplayName("junit5功能测试类")
@SpringBootTest
@Tag("渣男")
class ApplicationTests {
	@DisplayName("测试DisplayName注解")
	@Test
	void testDisplayName() {
		// 用于给类或者方法起一个测试用的别名，会开发工具中显示出来
		System.out.println("测试DisplayName注解");
	}

	@Test
	@Tag("直男")
	void testTag() {
		System.out.println("测试@Tag注解");
	}

	@Test
	@DisplayName("测试Add")
	@Disabled
	void testDisabled() {
		System.out.println("测试Disabled注解，代表当前的测试方法失效");
	}

	@DisplayName("重复测试注解")
	// 重复测试
	@RepeatedTest(5)
	void testRepeatedTest() {
		System.out.println("重复");
	}

	@Test
	@DisplayName("测试超时注解")
	// 如果当前方法超过了指定的时间就会抛出异常
	@Timeout(value = 3, unit = TimeUnit.SECONDS)
	void testTimeout() {
		try {
			Thread.sleep(3000);
			System.out.println("测试超时注解~");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// 所有方法执行之前都会执行
	@BeforeEach
	void testBeforeEach() {
		System.out.println("测试开始~");
	}

	// 所有方法执行之后都会执行
	@AfterEach
	void testAfterEach() {
		System.out.println("测试结束~");
	}

	// 在所有测试方法之前和之后执行一次，必须是静态的
	@BeforeAll
	static void testBeforeAll() {
		System.out.println("所有测试方法开始之前执行一次~");
	}

	@AfterAll
	static void testAfterAll() {
		System.out.println("所有测试方法开始之后执行一次~");
	}
}
