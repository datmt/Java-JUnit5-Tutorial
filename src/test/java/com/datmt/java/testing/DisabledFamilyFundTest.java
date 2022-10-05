package com.datmt.java.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DisabledFamilyFundTest {

    @Test
    @DisplayName("Normal test, will run")
    void this_test_will_run() {

    }

    @Test
    @DisplayName("Disabled test, will run")
    @Disabled
    void this_test_will_not_run() {

    }
}