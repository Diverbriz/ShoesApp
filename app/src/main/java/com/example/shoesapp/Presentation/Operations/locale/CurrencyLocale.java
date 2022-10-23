package com.example.shoesapp.Presentation.Operations.locale;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyLocale {
    private static Locale locale;



    public static Locale getLocale() {
        return locale;
    }

    public static void setLocale(Locale locale) {
        CurrencyLocale.locale = locale;
    }

    public static NumberFormat getCurrency(Locale locale){
        Currency current = Currency.getInstance(locale);
        return NumberFormat.getCurrencyInstance(locale);
    }
}
