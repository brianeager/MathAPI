package sojern.mathapi;

import org.junit.Test;
import sojern.mathapi.data.NumberAndQuantifierDTO;
import sojern.mathapi.service.CalculationService;

import java.math.BigDecimal;
import java.util.Arrays;

public class MaximumCalculationServiceTest {

    public CalculationService calculationService = new CalculationService();
    public TestHelper helper = new TestHelper();

    @Test
    public void calculateHappyPath(){
        NumberAndQuantifierDTO inputDataDTO = NumberAndQuantifierDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(1,2,3)))
                .quantifier(3)
                .build();
        helper.assertTrue(BigDecimal.valueOf(3), calculationService.calculateMaximum(inputDataDTO));
    }
}
