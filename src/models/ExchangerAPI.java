package models;

import java.util.List;
import java.util.Map;

public record ExchangerAPI(String base_code,
                           Map<String, Double> conversion_rates,
                           double rate) {

    public double exchange(String to, double amount) {
        return amount * conversion_rates.get(to);
    }
}
