package com.example.ryudug.jupiter;

import org.junit.jupiter.api.*;

@DisplayName("테스트 순서를 정하는 샘플")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {

    @DisplayName("세번째")
    @Test
    @Order(3)
    void nullValues() {

    }

    @DisplayName("두번째")
    @Test
    @Order(2)
    void emptyValues() {

    }

    @DisplayName("첫번째")
    @Test
    @Order(1)
    void validValues() {

    }

}
