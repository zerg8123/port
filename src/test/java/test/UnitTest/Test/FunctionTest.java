package test.UnitTest.Test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static test.Function.isNumberEven;
import static test.Function.isNumberPrime;

public class FunctionTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("metod add");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("metod run before");
    }

    @Test
    @DisplayName("Четное число передали в метод is..")
    @Disabled
    void testGivenEvenNumberWhenCheckIsEvenThenTrue(){
        boolean result = isNumberEven(2);
        Assertions.assertTrue(result);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5})
    void isNumberPrimeTest(int number) {
        Assertions.assertTrue(isNumberPrime(number));
    }

    @ParameterizedTest
    @CsvSource({"1, true", " 3, true", " 4, false"})
    void isNumberPrimeTest(int number, boolean result) {
        Assertions.assertEquals(result, isNumberPrime(number));
    }



    @AfterEach
    void afterEach() {
        System.out.println("after test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("after all");
    }
}
