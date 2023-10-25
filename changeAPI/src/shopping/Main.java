package shopping;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        CurrencyChanger currencyChanger = new CurrencyChanger();

        String responseA = currencyChanger.getChangeCurrency(ShopCurrency.GBP, ShopCurrency.USD);
        String responseB = currencyChanger.getChangeCurrency(ShopCurrency.HUF, ShopCurrency.EUR);

        double multiplierA = getMultiplier(responseA);
        double multiplierB = getMultiplier(responseB);
        
        System.out.println("Multipliers: " + multiplierA + ", " + multiplierB);
    }

    private static double getMultiplier(String response) {
        double multiplier = 0.0;
        for (int i = 0; i < response.length() - 10; i++) {
            String s = response.substring(i, i + 10);
            if (s.matches("[0-9]+\\.[0-9]{4,}")) {
                if (multiplier < Double.parseDouble(s)) {
                    multiplier = Double.parseDouble(s);
                }
            }
        }
        return multiplier;
    }
}
