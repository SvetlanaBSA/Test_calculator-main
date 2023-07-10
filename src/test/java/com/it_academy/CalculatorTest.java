package com.it_academy;

import com.it_academy.practice.junit_basics.Calculator;
import java.util.stream.Stream;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;


public class CalculatorTest {

    static Stream<Object[]> numbersForSum() {
        return Stream.of(new Object[][]{{1, 1}, {1, 0}, {3, -5}});
    }

    @ParameterizedTest
    @DisplayName("Test. Calculation the sum of two numbers")
    @MethodSource("numbersForSum")
    public void testCalculationSum(int firstNumber, int secondNumber) {
        var calculator = new Calculator(firstNumber, secondNumber);

        float expectedResult = firstNumber + secondNumber;
        float actualResult = calculator.calculate('+');

        Assertions.assertEquals(expectedResult, actualResult, "Expected result should be " + expectedResult);
        System.out.println("Expected = " + expectedResult + "; Actual = " + actualResult);
    }

    static Stream<Object[]> numbersForSubtraction() {
        return Stream.of(new Object[][]{{1, 1}, {3, 6}, {3, -5}});
    }

    @ParameterizedTest
    @DisplayName("Test. Calculation the subtraction of two numbers")
    @MethodSource("numbersForSubtraction")
    public void testCalculationSubtract(int firstNumber, int secondNumber) {
        var calculator = new Calculator(firstNumber, secondNumber);

        int expectedResult = firstNumber - secondNumber;
        int actualResult = (int) calculator.calculate('-');

        Assertions.assertEquals(expectedResult, actualResult, "Expected result should be " + expectedResult);
        System.out.println("Expected = " + expectedResult + "; Actual = " + actualResult);

    }

    static Stream<Object[]> numbersForMultiplication() {
        return Stream.of(new Object[][]{{1, 3}, {3, 0}, {3, -5}});
    }

    @ParameterizedTest
    @DisplayName("Test. Calculation the multiplication of two numbers")
    @MethodSource("numbersForMultiplication")
    public void testCalculationMultiply(int firstNumber, int secondNumber) {
        var calculator = new Calculator(firstNumber, secondNumber);

        int expectedResult = firstNumber * secondNumber;
        int actualResult = (int) calculator.calculate('*');

        Assertions.assertEquals(expectedResult, actualResult, "Expected result should be " + expectedResult);
        System.out.println("Expected = " + expectedResult + "; Actual = " + actualResult);
    }

    static Stream<Object[]> numbersForDivision() {
        return Stream.of(new Object[][]{{6, 2}, {1, 2}, {3, 0}, {0, 3}, {15, -5}, {-15, 5}, {-15, -5}});
    }

    @ParameterizedTest
    @DisplayName("Test. Calculation the division of two numbers")
    @MethodSource("numbersForDivision")
    public void testCalculationDivision(int firstNumber, int secondNumber) {
        var calculator = new Calculator(firstNumber, secondNumber);

        if (isErrorDuringCalculationByDivision(firstNumber, secondNumber)) {
            float expectedResult = firstNumber / secondNumber;
            float actualResult = calculator.calculate('/');

            Assertions.assertEquals(expectedResult, actualResult, "Expected result should be " + expectedResult);
            System.out.println("Expected = " + expectedResult + "; Actual = " + actualResult);
        }
    }

    static Stream<Object[]> numbersForExponent() {
        return Stream.of(new Object[][]{{2, 3}, {-2, 3}, {2, 0}, {-2, 0}, {2, -4}, {-2, -4}});
    }

    @ParameterizedTest
    @DisplayName("Test. Calculation the division of two numbers")
    @MethodSource("numbersForExponent")
    public void testCalculationExponentiation(int number, int power) {
        var calculator = new Calculator(number, power);

        float expectedResult = (float) Math. pow(number, power);
        float actualResult = calculator.calculate('e');

        Assertions.assertEquals(expectedResult, actualResult, "Expected result should be " + expectedResult);
        System.out.println("Expected = " + expectedResult + "; Actual = " + actualResult);
    }

    static Stream<Integer> numbersForSqrt() {
        return Stream.of(1, 0, -4, 4);
    }

    @ParameterizedTest
    @DisplayName("Test. Calculation the sqrt from number")
    @MethodSource("numbersForSqrt")
    public void testCalculationSqrtFromNumber(int number) {
        var calculator = new Calculator(number, 0);

        if (number >= 0) {
            float expectedResult = (float) Math.sqrt(number);
            float actualResult = calculator.calculate('s');

            Assertions.assertEquals(expectedResult, actualResult, "Expected result should be " + expectedResult);
            System.out.println("Expected = " + expectedResult + "; Actual = " + actualResult);
        } else {
            System.out.println("Error! Number should be >=0. Actual: " + number);
        }

    }

    boolean isErrorDuringCalculationByDivision(int firstNumber, int secondNumber) {

        boolean error = true;
        try {
            int expectedResult = firstNumber / secondNumber;
        } catch (ArithmeticException e) {
            error = false;
            System.out.println("Error! Cannot divide by zero!");
        }
        return error;
        }

}


