package sojern.mathapi.service;

import sojern.mathapi.data.NumberAndQuantifierDTO;
import sojern.mathapi.data.NumberDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CalculationService {

    public BigDecimal calculateMinimum(NumberAndQuantifierDTO inputDataDTO){
        return inputDataDTO.getNumbers()
                .stream()
                .min(Comparator.naturalOrder())
                .orElse(null);
    }

    public BigDecimal calculateMaximum(NumberAndQuantifierDTO inputDataDTO){
        return inputDataDTO.getNumbers()
                .stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
    }

    public BigDecimal calculateAverage(NumberDTO inputDataDTO){
        BigDecimal sum = inputDataDTO.getNumbers().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.divide(BigDecimal.valueOf(inputDataDTO.getNumbers().size()));
    }

    public BigDecimal calculateMedian(NumberDTO inputDataDTO){
        List<BigDecimal> numbersList = sortListOfNumbers(inputDataDTO.getNumbers());
        int size = numbersList.size();
        Boolean isEven = numbersList.size()%2==0;
        if(isEven){
            BigDecimal leftOfMedian = numbersList.get(size/2);
            BigDecimal rightOfMedian = numbersList.get(size/2-1);
            return leftOfMedian.add(rightOfMedian).divide(BigDecimal.valueOf(2));
        }else{
            return numbersList.get((size+1)/2-1);
        }
    }

    public BigDecimal calculatePercentile(NumberAndQuantifierDTO inputDataDTO){
        List<BigDecimal> numbersList = sortListOfNumbers(inputDataDTO.getNumbers());
        BigDecimal size = BigDecimal.valueOf(numbersList.size());
        BigDecimal percentile = BigDecimal.valueOf(inputDataDTO.getQuantifier());
        BigDecimal ordinalRankOfPercentile =
                percentile.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
                        .multiply(size);
        BigDecimal nearestRank = ordinalRankOfPercentile.setScale(0, RoundingMode.CEILING);
        return numbersList.get(nearestRank.intValue()-1);
    }


    private List<BigDecimal> sortListOfNumbers(List<BigDecimal> bigDecimals) {
        List<BigDecimal> listToSort = bigDecimals;
        Collections.sort(listToSort);
        return listToSort;
    }
}
