package com.example.ryudug.jupiter;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@DisplayName("@Disabled, @DisplayName 샘플")
public class MethodTest {
    @Test
    @Disabled("skip하는 테스트")
    void skippedTest() {
        assertEquals(1, 2);
    }

    @Test
    @DisplayName("테스트에 대한 설명을 넣는 어노테이션.")
    void test1() {
        assertNotEquals(1, 2);
    }

    @Test
    @DisplayName("1과 3는 같지 않다")
    void test2() {
        assertNotEquals(1, 3);
    }
}
