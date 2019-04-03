package com.example.ryudug.jupiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import static org.junit.jupiter.api.condition.OS.*;

@DisplayName("Conditional 테스트 샘플")
public class ConditionTest {

    @DisplayName("mac에서 실행")
    @Test
    @EnabledOnOs(MAC)
    void onlyOnMacOs() {
        // ...
    }

    @DisplayName("window, linux에서 실행")
    @Test
    @EnabledOnOs({WINDOWS, LINUX})
    void onLinuxOrMac() {
        // ...
    }

    @DisplayName("mac에서 실행하지 않음")
    @Test
    @DisabledOnOs(MAC)
    void notOnWindows() {
        // ...
    }

    @DisplayName("condition에 따라 실행하지 않음")
    @RepeatedTest(100)
    @DisabledIf("Math.random() < 0.3")
    void mightNotBeExecuted() {
        // ...
    }

    @DisplayName("jvm옵션에 따라 실행, vm options:  -Dspring.profiles.active=local 추가")
    @Test
    @EnabledIfSystemProperty(named = "spring.profiles.active", matches = "local")
    void conditionOnSpringProfileLocal() {
        // ...
    }

}
