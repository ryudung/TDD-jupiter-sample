package com.example.ryudug.jupiter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("@ParameterizedTest 샘플")
public class ParameterizTest {

    @DisplayName("@ValueSource string 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
    void palindromesString(String candidate) {

        List<String> strings = Arrays.asList("racecar", "radar", "able was I ere I saw elba");

        assertTrue(strings.contains(candidate));
    }


    @DisplayName("@ValueSource int 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void palindromesInt(int candidate) {

        List<Integer> ints = Arrays.asList(1, 2, 3, 4);

        assertTrue(ints.contains(candidate));
    }

    @DisplayName("@EnumSource int 테스트")
    @ParameterizedTest
    @EnumSource(TimeUnit.class)
    void testWithEnumSource(TimeUnit timeUnit) {
        assertNotNull(timeUnit);
    }


    @DisplayName("@NullSource 테스트")
    @ParameterizedTest
    @NullSource
    void nullSource(String text) {
        assertTrue(text == null);
    }


    @DisplayName("@EmptySource 테스트")
    @ParameterizedTest
    @EmptySource
    void emptySource(String text) {
        assertTrue(text == "");
    }


    @DisplayName("@EmptySource, @NullSource 테스트")
    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void nullEmptyAndBlankStrings(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }


    @DisplayName("@NullAndEmptySource 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    void nullEmptyAndBlankStrings2(String text) {
        assertTrue(text == null || text.trim().isEmpty());
    }

}
