package tests;

import org.example.calculator.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import dataProviders.CalculatorDataProviders;

public class CalculatorTest {
    static Calculator calculator;

    @BeforeClass
    public void setUp()
    {
        calculator = new Calculator();
    }

    @Test
    public void  testAddingPositiveNumbers()
    {
        System.out.println("Verify that sum:" + calculator.compute(4, 5, "+") + " is equal to 9");
        Assert.assertEquals(calculator.compute(4, 5, "+"), 9);
    }

    @Test(dataProvider = "calculatorPositiveDataProvider", dataProviderClass = CalculatorDataProviders.class)
    public void testOperationsUsingPositiveNumbers(double d1, double d2, String operation, double expected)
    {
        Assert.assertEquals(calculator.compute(d1, d2, operation), expected, 0.00001);
    }
}