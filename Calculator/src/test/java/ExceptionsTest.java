import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ExceptionsTest {
    @DataProvider(name = "testExceptionData")
    public Object[][] createExceptionData() {
        return new Object[][]{
                {new Integer(Integer.MAX_VALUE), new Integer(1), new Character('+')},
                {new Integer(Integer.MAX_VALUE), new Integer(-1), new Character('-')},
                {new Integer(Integer.MIN_VALUE), new Integer(-1), new Character('+')},
                {new Integer(Integer.MIN_VALUE), new Integer(1), new Character('-')},
                {new Integer(-45000000), new Integer(9000), new Character('*')},
                {new Integer(45000000), new Integer(-9000), new Character('*')},
                {new Integer(-45000000), new Integer(-9000), new Character('*')},
                {new Integer(-45000000), new Integer(9000), new Character('*')},
                {new Integer(1), new Integer(0), new Character('/')},
                {new Integer(Integer.MIN_VALUE), new Integer(1 / 5), new Character('/')},
                {new Integer(Integer.MAX_VALUE), new Integer(1 / 2), new Character('/')},
                {new Integer(1), new Integer(1 / Integer.MIN_VALUE), new Character('/')},
        };
    }

    @Test(dataProvider = "testExceptionData")
    public void testException(Integer firstNumber, Integer secondNumber, Character operation) {
        Assert.assertThrows(ArithmeticException.class, () -> Calculator.calculate(firstNumber, secondNumber, operation));
    }

    @DataProvider(name = "testExceptionFunctionData")
    public Object[][] createExceptionFunctionData() {
        return new Object[][]{
                {new Integer(Integer.MAX_VALUE), new Integer(1)},
                {new Integer(Integer.MIN_VALUE), new Integer(-1)},
        };
    }

    @Test(dataProvider = "testExceptionFunctionData")
    public void testException(Integer firstNumber, Integer secondNumber) {
        Assert.assertThrows(ArithmeticException.class, () -> Calculator.add(firstNumber, secondNumber));
    }

    @DataProvider(name = "testExceptionMinusData")
    public Object[][] createExceptionFunctionSubtractData() {
        return new Object[][]{
                {new Integer(Integer.MAX_VALUE), new Integer(-1)},
                {new Integer(Integer.MIN_VALUE), new Integer(1)},
        };
    }

    @Test(dataProvider = "testExceptionMinusData")
    public void testSubtractException(Integer firstNumber, Integer secondNumber) {
        Assert.assertThrows(ArithmeticException.class, () -> Calculator.subtract(firstNumber, secondNumber));
    }

    @DataProvider(name = "testExceptionPlusData")
    public Object[][] createExceptionFunctionSumData() {
        return new Object[][]{
                {new Integer(Integer.MAX_VALUE), new Integer(1)},
                {new Integer(Integer.MIN_VALUE), new Integer(-1)},
        };
    }

    @Test(dataProvider = "testExceptionPlusData")
    public void testSumException(Integer firstNumber, Integer secondNumber) {
        Assert.assertThrows(ArithmeticException.class, () -> Calculator.add(firstNumber, secondNumber));
    }

    @DataProvider(name = "testExceptionMultiplyData")
    public Object[][] createExceptionFunctionMulData() {
        return new Object[][]{
                {new Integer(-45000000), new Integer(9000)},
                {new Integer(45000000), new Integer(-9000)},
                {new Integer(-45000000), new Integer(-9000)},
                {new Integer(-45000000), new Integer(9000)},
        };
    }

    @Test(dataProvider = "testExceptionMultiplyData")
    public void testMulException(Integer firstNumber, Integer secondNumber) {
        Assert.assertThrows(ArithmeticException.class, () -> Calculator.multiply(firstNumber, secondNumber));
    }

    @DataProvider(name = "testExceptionDivData")
    public Object[][] createExceptionFunctionDivData() {
        return new Object[][]{
                {new Integer(Integer.MIN_VALUE), new Integer(1 / 5)},
                {new Integer(Integer.MAX_VALUE), new Integer(1 / 2)},
                {new Integer(1), new Integer(1 / Integer.MIN_VALUE)},
        };
    }

    @Test(dataProvider = "testExceptionDivData")
    public void testDivException(Integer firstNumber, Integer secondNumber) {
        Assert.assertThrows(ArithmeticException.class, () -> Calculator.divide(firstNumber, secondNumber));
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testSubtractOverflow() {
        int result = Calculator.subtract(Integer.MAX_VALUE, -1);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testMulOverflow() {
        int result = Calculator.multiply(-45000000, -9000);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testSumOverflow() {
        int result = Calculator.add(Integer.MAX_VALUE, 1);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivOverflow() {
        int result = Calculator.divide(1, 0);
    }

}
