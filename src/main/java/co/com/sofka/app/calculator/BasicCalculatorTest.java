package co.com.sofka.app.calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.testng.annotations.Test;

@Test
@DisplayName("Testing calculator")
public class BasicCalculatorTest {
    private BasicCalculator basicCalculator;

    @BeforeEach
    public void setup(){
        basicCalculator = new BasicCalculator();
    }

    @ParameterizedTest(name = "{0}+{1}={2}")
    @CsvSource({"3,2,5","4,5,9","10,15,25"})
    void sum(long one, long two, long expective){
        long result = basicCalculator.sum(one,two);
        Assertions.assertEquals(expective,result);

    }

    @ParameterizedTest(name = "{0}-{1}={2}")
    @CsvSource({"3,2,1","4,5,-1","10,15,-5"})
    void sustract(long one, long two, long expective){
        long result = basicCalculator.sustract(one,two);
        Assertions.assertEquals(expective,result);

    }

    @ParameterizedTest(name = "{0}*{1}={2}")
    @CsvSource({"3,2,6","4,5,20","10,15,150"})
    void product(long one, long two, long expective){
        long result = basicCalculator.product(one,two);
        Assertions.assertEquals(expective,result);

    }

    @ParameterizedTest(name = "{0}/{1}={2}")
    @CsvSource({"15,3,5","4,1,4","50,5,10"})
    void div(long one, long two, long expective){
        long result = basicCalculator.div(one,two);
        Assertions.assertEquals(expective,result);
    }


    @ParameterizedTest(name = "{0}/{1}={2}")
    @CsvSource({"4,0","0,0"})
    void diverror(long one, long two){
        var response = Assertions.assertThrows(RuntimeException.class,()->{
            long result = basicCalculator.div(one,two);
        });

        Assertions.assertEquals("No se puede dividir por cero",response.getMessage());
    }

}
