import org.testng.Assert;
import org.testng.annotations.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CalculatorTests {
    @DataProvider(name = "testSumData")
    public Object[][] createSumData() {
        return new Object[][] {
                { new Integer(1), new Integer(0), new Integer(1) },
                { new Integer(-5), new Integer(5), new Integer(0)},
                { new Integer(-5), new Integer(-5), new Integer(-10)},
        };
    }

    @Test(dataProvider = "testSumData")
    public void testSum (Integer firstSummand , Integer secondSummand, Integer sum ) throws Exception {
        Assert.assertEquals(sum, Calculator.calculate(firstSummand, secondSummand, '+' ));
    }
    @Test(dataProvider = "testSumData")
    public void testAddFunction (Integer firstSummand , Integer secondSummand, Integer sum ) throws Exception {
        Assert.assertEquals(sum, Calculator.add(firstSummand, secondSummand));
    }

    @DataProvider(name = "testSubtractData")
    public Object[][] createSubtractData() {
        return new Object[][] {
                { new Integer(10), new Integer(0), new Integer(10) },
                { new Integer(-5), new Integer(-5), new Integer(0)},
        };
    }

    @Test(dataProvider = "testSubtractData")
    public void testSubtract (Integer reduce , Integer subtract, Integer difference ) throws Exception {
        Assert.assertEquals(difference, Calculator.calculate(reduce, subtract, '-' ));
    }
    @Test(dataProvider = "testSubtractData")
    public void testSubtractFunction (Integer reduce , Integer subtract, Integer difference ) throws Exception {
        Assert.assertEquals(difference, Calculator.subtract(reduce, subtract));
    }

    @DataProvider(name = "testMultiplyData")
    public Object[][] createMultiplyData() {
        return new Object[][] {
                { new Integer(10), new Integer(0), new Integer(0) },
                { new Integer(-5), new Integer(-5), new Integer(25)},
                { new Integer(1), new Integer(-5), new Integer(-5)},
                { new Integer(2), new Integer(2), new Integer(4)},
                { new Integer(2), new Integer(1), new Integer(2)},
                { new Integer(0), new Integer(0), new Integer(0)},
        };
    }
    @Test(dataProvider = "testMultiplyData")
    public void testMultiply(Integer firstNumber, Integer secondNumber, Integer multiplyResult){
        Assert.assertEquals(multiplyResult, Calculator.calculate(firstNumber, secondNumber, '*' ));

    }
    @Test(dataProvider = "testMultiplyData")
    public void testMultiplyFunction(Integer firstNumber, Integer secondNumber, Integer multiplyResult){
        Assert.assertEquals(multiplyResult, Calculator.multiply(firstNumber, secondNumber ));
    }

    @DataProvider(name = "testDivideData")
    public Object[][] createDivideData() {
        return new Object[][] {
                { new Integer(10), new Integer(1), new Integer(10) },
                { new Integer(-5), new Integer(-5), new Integer(1)},
                { new Integer(0), new Integer(-5), new Integer(0)},
        };
    }

    @Test(dataProvider = "testDivideData")
    public void testDivide(Integer firstNumber, Integer secondNumber, Integer divideResult){
        Assert.assertEquals(divideResult, Calculator.calculate(firstNumber, secondNumber, '/' ));

    }
}
