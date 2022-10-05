package com.datmt.java.testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LifecycleFamilyFundTest {
    @BeforeAll
    static void setupAll() {
        System.out.println("This runs before all tests");
    }
    @BeforeEach
    void setupEach() {
        System.out.println("this run before every tests");
    }

    @Test
    @DisplayName("Test 1")
    void test_1() {
        System.out.println("Inside test 1");
    }

    @Test
    @DisplayName("Test 2")
    void test_2() {
        System.out.println("Inside test 2");
    }

    @AfterEach
    void afterEach() {
        System.out.println("this runs after every tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This runs after all tests");
    }

}
