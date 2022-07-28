package sojern.mathapi;

import org.junit.Test;
import sojern.mathapi.data.NumberAndQuantifierDTO;
import sojern.mathapi.data.NumberDTO;
import sojern.mathapi.service.CalculationService;

import java.math.BigDecimal;
import java.util.Arrays;

public class MedianCalculationServiceTest {

    public CalculationService calculationService = new CalculationService();
    public TestHelper helper = new TestHelper();

    @Test
    public void calculateHappyPathOdd(){
        NumberDTO inputDataDTO = NumberDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(1,2,3)))
                .build();
        helper.assertTrue(BigDecimal.valueOf(2), calculationService.calculateMedian(inputDataDTO));
    }

    @Test
    public void calculateHappyPathEven(){
        NumberDTO inputDataDTO = NumberDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(1,2,3,4)))
                .build();
        helper.assertTrue(BigDecimal.valueOf(2.5), calculationService.calculateMedian(inputDataDTO));
    }

    @Test
    public void calculateOddDifficult(){
        NumberDTO inputDataDTO = NumberDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(2,105,6,25,8,16,19,85,18)))
                .build();
        helper.assertTrue(BigDecimal.valueOf(18), calculationService.calculateMedian(inputDataDTO));
    }

    @Test
    public void calculateEvenDifficult(){
        NumberDTO inputDataDTO = NumberDTO.builder()
                .numbers(helper.listHelper(Arrays.asList(8,98,17,2,68,30,48,76)))
                .build();
        helper.assertTrue(BigDecimal.valueOf(39), calculationService.calculateMedian(inputDataDTO));
    }
}
