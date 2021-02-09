package Exercises6_0;

public class CelsiusToFahrenheit implements Converter {
    @Override
    public double convert(double temperature) {
        return (9.0 * temperature) / 5.0 + 32.0;
    }
}
