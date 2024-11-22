package conversor_moedas;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class ExchangeRateResponse {
    @SerializedName("conversion_rates")
    private Map<String, Double> conversionRates;

    public Map<String, Double> getConversionRates() {
        return conversionRates;
    } 
    
    public double getRate(String currency) {
        return conversionRates.getOrDefault(currency, 0.0);
    }
}
