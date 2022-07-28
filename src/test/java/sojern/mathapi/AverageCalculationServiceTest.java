package sojern.mathapi;

import org.junit.Test;
import sojern.mathapi.data.NumberAndQuantifierDTO;
import sojern.mathapi.data.NumberDTO;
import sojern.mathapi.service.CalculationService;

import java.math.BigDecimal;
import java.util.Arrays;

public class AverageCalculationServiceTest {

    public CalculationService calculationService = new CalculationService();
    public TestHelper helper = new TestHelper();

    @Test
    public void calculateHappyPath(){
        NumberDTO inputDataDTO = NumberDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(1,2,3)))
                .build();
        helper.assertTrue(BigDecimal.valueOf(2), calculationService.calculateAverage(inputDataDTO));
    }
}
