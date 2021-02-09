// Конвертер температур.

import Exercises6_0.*;

public class Exercises6_0 {
    public static void main(String[] args) {
        double temperature = 0.0;
        Converter converter1 = new CelsiusToKelvins();
        Converter converter2 = new CelsiusToFahrenheit();

        System.out.println(String.format("Celsius scale: %.3g", temperature));
        System.out.println(String.format("Fahrenheit scale: %.3g", converter1.convert(temperature)));
        System.out.println(String.format("Kelvin scale: %.3g", converter2.convert(temperature)));
    }
}
