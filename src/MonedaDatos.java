import java.util.List;
import java.util.Map;

public record MonedaDatos(String base_code,
                          Map<String, Double> conversion_rates
                     ) {
}
