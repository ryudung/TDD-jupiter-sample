package com.example.ryudug.jupiter;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("라이프 사이클 샘플")
public class LifecycleTest {

    @BeforeAll
    static void initAll() {
        System.out.println("@BeforeAll");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach");
    }


    @Test
    void test1() {
        assertEquals(1, 1);
    }

    @Test
    void test2() {
        assertEquals(2, 2);
    }


    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("@AfterAll");
    }
}
