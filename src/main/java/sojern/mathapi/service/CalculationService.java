package sojern.mathapi.service;

import sojern.mathapi.data.NumberAndQuantifierDTO;
import sojern.mathapi.data.NumberDTO;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CalculationService {

    /**
     * Given a list of numbers, return minumum value(s)
     * @param inputDataDTO List of BigDecimals and a Quantifier
     * @return BigDecimal
     */
    public List<BigDecimal> calculateMinimum(NumberAndQuantifierDTO inputDataDTO){
        BigDecimal minimum = inputDataDTO.getNumbers()
                .stream()
                .min(Comparator.naturalOrder())
                .orElse(null);
        //return all matching minimum values
        return inputDataDTO.getNumbers().stream()
                .filter(number -> number.compareTo(minimum)==0)
                .collect(Collectors.toList());
    }

    /**
     * Given a list of numbers, return maxmium value(s)
     * @param inputDataDTO List of BigDecimals and a Quantifier
     * @return BigDecimal
     */
    public List<BigDecimal> calculateMaximum(NumberAndQuantifierDTO inputDataDTO){
        BigDecimal maxmium = inputDataDTO.getNumbers()
                .stream()
                .max(Comparator.naturalOrder())
                .orElse(null);
        //return all matching maximum values
        return inputDataDTO.getNumbers().stream()
                .filter(number -> number.compareTo(maxmium)==0)
                .collect(Collectors.toList());
    }

    /**
     * Calculate average given a list of values
     * @param inputDataDTO List of BigDecimals
     * @return BigDecimal
     */
    public BigDecimal calculateAverage(NumberDTO inputDataDTO){
        BigDecimal sum = inputDataDTO.getNumbers().stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.divide(BigDecimal.valueOf(inputDataDTO.getNumbers().size()),RoundingMode.HALF_UP);
    }

    /**
     * Calculate median given a list of values
     * @param inputDataDTO List of BigDecimals
     * @return BigDecimal
     */
    public BigDecimal calculateMedian(NumberDTO inputDataDTO){
        List<BigDecimal> numbersList = sortListOfNumbers(inputDataDTO.getNumbers());
        int size = numbersList.size();
        boolean isEven = numbersList.size()%2==0;
        if(isEven){
            BigDecimal leftOfMedian = numbersList.get(size/2);
            BigDecimal rightOfMedian = numbersList.get(size/2-1);
            return leftOfMedian.add(rightOfMedian).divide(BigDecimal.valueOf(2), RoundingMode.HALF_UP);
        }else{
            return numbersList.get((size+1)/2-1);
        }
    }

    /**
     * Calculate Percentile using Nearest-Rank method, given a list of values and a quantifier
     * @param inputDataDTO List of BigDecimals and a Quantifier
     * @return BigDecimal
     */
    public BigDecimal calculatePercentile(NumberAndQuantifierDTO inputDataDTO){
        List<BigDecimal> numbersList = sortListOfNumbers(inputDataDTO.getNumbers());
        BigDecimal size = BigDecimal.valueOf(numbersList.size());
        BigDecimal percentile = BigDecimal.valueOf(inputDataDTO.getQuantifier());
        //Get ordinal rank of percentile
        BigDecimal ordinalRankOfPercentile =
                percentile.divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP)
                        .multiply(size);
        //Round up to the nearest whole number to get the next rank
        BigDecimal nearestRank = ordinalRankOfPercentile.setScale(0, RoundingMode.CEILING);
        //Return previous value to get nearest value to rank
        return numbersList.get(nearestRank.intValue()-1);
    }


    /**
     * Sort list of values from smallest to largest
     * @param bigDecimals
     * @return BigDecimal
     */
    private List<BigDecimal> sortListOfNumbers(List<BigDecimal> bigDecimals) {
        List<BigDecimal> listToSort = bigDecimals;
        Collections.sort(listToSort);
        return listToSort;
    }
}
