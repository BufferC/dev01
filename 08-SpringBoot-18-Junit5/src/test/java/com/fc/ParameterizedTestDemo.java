package com.fc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

public class ParameterizedTestDemo {

    @ParameterizedTest
    @ValueSource(strings = {"one", "two", "three"})
    @DisplayName("参数化测试1")
    public void parameterizedTest1(String string) {
        System.out.println(string);
        Assertions.assertTrue(!string.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("method") //指定方法名
    @DisplayName("方法来源参数")
    public void testWithExplicitLocalMethodSource(String name) {
        System.out.println(name);
        Assertions.assertNotNull(name);
    }

    static List<String> method() {
        List<String> list = new ArrayList<>();
        list.add("易烊千玺");
        list.add("迪丽热巴");
        list.add("古力娜扎");
        list.add("欧阳娜娜");
        list.add("猪肉香菇");
        list.add("猪肉大葱");
        list.add("猪肉茴香");
        list.add("猪肉韭菜");

        return list;
    }
}