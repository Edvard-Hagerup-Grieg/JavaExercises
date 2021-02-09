package Exercises6_0;

public class CelsiusToKelvins implements Converter {
    @Override
    public double convert(double temperature) {
        return temperature + 273.15;
    }
}
