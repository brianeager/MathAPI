package sojern.mathapi;

import org.junit.Test;
import sojern.mathapi.data.NumberAndQuantifierDTO;
import sojern.mathapi.service.CalculationService;

import java.math.BigDecimal;
import java.util.Arrays;

public class PercentileCalculationServiceTest {

    public CalculationService calculationService = new CalculationService();
    public TestHelper helper = new TestHelper();

    @Test
    public void calculateHappyPath(){
        NumberAndQuantifierDTO inputDataDTO = NumberAndQuantifierDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(10,35,40,50,80)))
                .quantifier(60)
                .build();
        helper.assertTrue(BigDecimal.valueOf(40), calculationService.calculatePercentile(inputDataDTO));
    }

    @Test
    public void calculateHappyPath2(){
        NumberAndQuantifierDTO inputDataDTO = NumberAndQuantifierDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(10,40,50,80,35)))
                .quantifier(61)
                .build();
        helper.assertTrue(BigDecimal.valueOf(50), calculationService.calculatePercentile(inputDataDTO));
    }

    @Test
    public void calculateDifficult(){
        NumberAndQuantifierDTO inputDataDTO = NumberAndQuantifierDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(7,19,39,44,13,65,11,44,69,27,33,44,19)))
                .quantifier(60)
                .build();
        helper.assertTrue(BigDecimal.valueOf(39), calculationService.calculatePercentile(inputDataDTO));
    }
}
