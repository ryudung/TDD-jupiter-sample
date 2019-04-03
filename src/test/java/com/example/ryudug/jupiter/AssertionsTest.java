package com.example.ryudug.jupiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Assertions 대한 새픔")
public class AssertionsTest {

    @Test
    @DisplayName("assertEquals(예상값, 실제값, '비교에 대한 설명')")
    void test1() {

        assertEquals(2, 2, "2는 2의 비교는 같다.");

    }

    @Test
    @DisplayName("assertAll('테스트 내용', 람다...)")
    void test2() {
        assertAll("외부 테스트",
                () -> {
                    assertAll("내부 테스트1",
                            () -> assertTrue(1 > 0),
                            () -> assertTrue(2 > 1)
                    );
                },
                () -> {
                    assertAll("내부 테스트2",
                            () -> assertEquals("내부테스트2", "내부테스트2"),
                            () -> assertEquals('c', 'c')
                    );
                }
        );
    }

    @Test
    @DisplayName("에러 처리 테스트")
    void exceptionTesting() {

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            int a = 1;
            int b = 0;
            int c = a / b;
        });

        assertEquals("/ by zero", exception.getMessage());
    }

    @Test
    @DisplayName("타임아웃 테스트")
    void timeoutNotExceeded() {

        assertTimeout(ofSeconds(5), () -> {
            System.out.println("성공!");
        });
    }

    @Test
    @DisplayName("타임아웃 실패 테스트")
    void timeoutNotExceeded2() {

        assertThrows(AssertionFailedError.class, ()->assertTimeout(ofSeconds(1), () -> {
            Thread.sleep(2000);
            System.out.println("실패!");
        }));

    }
}
