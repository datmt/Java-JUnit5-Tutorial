package com.datmt.java.testing;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsExamples {


    @Test
    void assert_equality() {
        assertEquals(1, 1);
        assertNotEquals(1, 2);

        assertEquals("hello", new String("hello"));
    }

    @Test
    void nullity_assertion() {
        var testString = "Hello";
        assertNotNull(testString);

        testString = null;
        assertNull(testString);

    }

    //This assertion will file
    @Test
    @Disabled
    void assert_array_equality() {
        var names = new String[]{"Jane", "Jill", "Jack"};
        var alsoNames = new String[]{"Jill", "Jack", "Jane"};

        assertArrayEquals(names, alsoNames);
    }


    @Test
    void assert_array_equality_equal() {
        var names = new String[]{"Jane", "Jill", "Jack"};
        var alsoNames = new String[]{"Jane", "Jill", "Jack"};

        assertArrayEquals(names, alsoNames);
    }

    static class TruckDiver {
        private String name;
        private Experience ex;

        public TruckDiver(String name, int yearsOfExperience) {
            this.name = name;
            this.ex = new Experience();
            ex.setYears(yearsOfExperience);
        }

        static class Experience {
            private int years;

            public void setYears(int years) {
                this.years = years;
            }
        }
    }

    @Test
    void test_array_equality_complex_objects() {
        var jane = new TruckDiver("Jane", 10);
        var karen = new TruckDiver("Karen", 18);

        var janeClone = new TruckDiver("Jane", 10);
        var karenClone = new TruckDiver("Karen", 18);


        var localDrivers = new TruckDiver[]{jane, karen};
        var alsoLocalDrivers = new TruckDiver[]{janeClone, karenClone};

        assertNotSame(localDrivers, alsoLocalDrivers);
        assertArrayEquals(localDrivers, alsoLocalDrivers);
    }


    @Test
    void test_assert_iterable_equality() {
        var names = List.of("Jane", "Jake", "Jill");
        var alsoNames = new LinkedList<>(List.of("Jane", "Jake", "Jill"));
        assertIterableEquals(names, alsoNames);
    }

    @Test
    void test_same_object() {
        var x = "Hello";
        var y = "Hello";

        var dog = "Dog";
        var alsoDog = new String("Dog");

        assertSame(x, y);
        assertNotSame(dog, alsoDog);
    }

    @Test
    void test_multiple_assertion_with_assert_all() {
        assertAll(
                () -> {
                    var x = 1/0;
                },
                () -> {

                }

                );
    }
}
