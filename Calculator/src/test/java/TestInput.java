import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TestInput {

    @DataProvider(name = "flagVariants")
    public Object[][] getData() {
        return new Object[][]{
                {"1"},
                {"q"},
                {"/"},
                {" "},
                {"й"},
                {"qwerty"},
                {"/n"}
        };
    }

    @Test(dataProvider = "flagVariants")
    public void testStartFlag(String starFlag) {
        Assert.assertFalse(Calculator.startAgain(starFlag), "Stop calculator");
    }

    @Test()
    public void testCorrectStartFlag() {
        Assert.assertTrue(Calculator.startAgain("0"));
    }

    @Test
    public void testIncorrectData(){

    }

}
