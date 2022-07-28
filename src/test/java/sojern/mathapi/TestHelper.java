package sojern.mathapi;

import org.junit.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public List<BigDecimal> listHelper(List<Integer> integers){
        List<BigDecimal> bigDecimals = new ArrayList<>();
        for(int integer: integers){
            bigDecimals.add(BigDecimal.valueOf(integer));
        }
        return  bigDecimals;
    }

    public void assertTrue(final BigDecimal expectedValue,
                            final BigDecimal actualValue){
        Assert.assertTrue(expectedValue.compareTo(actualValue)==0);
    }
}
