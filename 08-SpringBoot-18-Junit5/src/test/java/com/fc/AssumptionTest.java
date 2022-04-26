package com.fc;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("前置条件")
public class AssumptionTest {
    private final String environment = "test";

    @Test
    @DisplayName("简单条件")
    void testSimpleAssume() {
        Assumptions.assumeFalse(() -> this.environment.equals("test"));
    }

    @Test
    @DisplayName("Then do")
    void testThenDo() {
        Assumptions.assumingThat(this.environment.equals("dev"), () -> {
            System.out.println("当前环境是测试环境！");
        });
    }
}
