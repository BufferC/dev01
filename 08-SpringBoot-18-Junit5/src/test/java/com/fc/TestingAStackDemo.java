package com.fc;

import org.junit.jupiter.api.*;

import java.util.EmptyStackException;
import java.util.Stack;

// 官方文档案例，一个栈的测试类
@DisplayName("A stack")
class TestingAStackDemo {
    // 声明一个栈
    Stack<Object> stack;

    @Test
    @DisplayName("is instantiated with new Stack()")
    void isInstantiatedWithNew() {
        new Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {
        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
            System.out.println("初始化栈，此时栈不为null");
        }

        @Test
        @DisplayName("is empty")
        void isEmpty() {
            Assertions.assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void throwsExceptionWhenPopped() {
            Assertions.assertThrows(EmptyStackException.class, () -> {
                System.out.println("从栈中弹出一个元素");
                stack.pop();
            });
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void throwsExceptionWhenPeeked() {
            Assertions.assertThrows(EmptyStackException.class, () -> {
                System.out.println("从栈中拿到一个元素，元素没有被栈删除");
                stack.peek();
            });
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {
            String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void isNotEmpty() {
                Assertions.assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void returnElementWhenPopped() {
                Assertions.assertEquals(anElement, stack.pop());
                Assertions.assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void returnElementWhenPeeked() {
                Assertions.assertEquals(anElement, stack.peek());

                Assertions.assertFalse(stack.isEmpty());
            }
        }
    }
}