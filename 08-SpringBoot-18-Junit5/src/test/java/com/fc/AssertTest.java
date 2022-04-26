package com.fc;

import com.fc.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

@DisplayName("测试断言")
@SpringBootTest
public class AssertTest {
    @Autowired
    private User user1;
    @Autowired
    private User user2;

    int count(int a, int b) {
        return a + b;
    }

    @Test
    void testAdd() {
        int count = count(1, 2);
        Assertions.assertEquals(4, count);
    }

    @Test
    void testEquals() {

        //Assertions.assertNotEquals(new Object(), new Object(), "你们的老婆是同一个人？");

        System.out.println("--------------");

        //Assertions.assertSame(user1, user2, "同一个人？");

        Assertions.assertNotNull(user1, "是null吗？");
    }

    @Test
    void testArray() {
        Assertions.assertArrayEquals(new int[]{2, 1}, new int[]{1, 2}, "不是同一个数组！！！");
    }

    @Test
    @DisplayName("测试组合断言")
    void testAll() {
        Assertions.assertAll("测试组合断言",
                () -> Assertions.assertNull(user1, "是null吗？"),
                () -> {
                    int count = count(1, 2);
                    Assertions.assertEquals(4, count, "算术都不会，垃圾");
                },
                () -> Assertions.assertNotEquals(new Object(), new Object(), "你们的老婆是同一个人？"));
    }

    @DisplayName("异常断言测试")
    @Test
    void testException() {
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            System.out.println(1 / 0);
        }, "竟然能正常运行？？？");

        System.out.println(exception.getMessage());
    }

    @Test
    @DisplayName("测试超时断言")
    void testTimeout() {
        Assertions.assertTimeout(Duration.ofSeconds(4L), () -> {
            Thread.sleep(3000);
        }, "您的订单已超时！！！！");
    }

    @Test
    @DisplayName("测试快速失败")
    void shouldFail() {
        Assertions.fail("失败了！");
    }
}
