package sojern.mathapi.data;

import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NumberAndQuantifierDTO {
    private List<BigDecimal> numbers;
    private int quantifier;
}
