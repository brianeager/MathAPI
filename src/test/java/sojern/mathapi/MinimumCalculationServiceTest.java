package sojern.mathapi;

import org.junit.Test;
import sojern.mathapi.data.NumberAndQuantifierDTO;
import sojern.mathapi.service.CalculationService;

import java.math.BigDecimal;
import java.util.Arrays;

public class MinimumCalculationServiceTest {

    public CalculationService calculationService = new CalculationService();
    public TestHelper helper = new TestHelper();

    @Test
    public void calculateHappyPath(){
        NumberAndQuantifierDTO inputDataDTO = NumberAndQuantifierDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(1,2,3)))
                .quantifier(3)
                .build();
        helper.assertTrue(BigDecimal.valueOf(1), calculationService.calculateMinimum(inputDataDTO).get(0));
    }

    @Test
    public void calculateMultipleValues(){
        NumberAndQuantifierDTO inputDataDTO = NumberAndQuantifierDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(10,25,36,10)))
                .quantifier(3)
                .build();
        helper.assertTrue(BigDecimal.valueOf(10), calculationService.calculateMinimum(inputDataDTO).get(0));
        helper.assertTrue(BigDecimal.valueOf(10), calculationService.calculateMinimum(inputDataDTO).get(1));
    }
}
