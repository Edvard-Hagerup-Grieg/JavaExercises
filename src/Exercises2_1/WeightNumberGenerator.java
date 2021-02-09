package Exercises2_1;

public class WeightNumberGenerator {
    private int[] values;
    private int[] weights;
    private double[] boundaries;

    public int[] getValues() { return values; }
    public int[] getWeights() { return weights; }
    public double[] getBoundaries() { return boundaries; }

    public WeightNumberGenerator(int count) {
        values = new int[count];
        weights = new int[count];

        for(int i = 0; i < count; i++) {
            values[i] = i + 1;
            weights[i] = (int)(Math.random() * 10);
        }

        boundariesInitialize();
    }

    public WeightNumberGenerator(int[] userValues, int[] userWeights) {
        values = userValues;
        weights = userWeights;

        boundariesInitialize();
    }

    private void boundariesInitialize() {
        boundaries = new double[weights.length];

        for(int i = 0; i < boundaries.length; i++) {
            boundaries[i] = weights[i];
            for(int j = 0; j < i; j++) {
                boundaries[i] += weights[j];
            }
        }

        double normConst= boundaries[boundaries.length - 1];
        for(int i = 0; i < boundaries.length; i++) {
            boundaries[i] /= normConst;
        }
    }

    public int next() {
        double randomPoint = Math.random();

        int i = 0;
        while(randomPoint > boundaries[i]) i++;

        return values[i];
    }

    public int[] next(int numberItems) {
        int[] items = new int[numberItems];

        for(int i = 0; i < numberItems; i++) {
            items[i] = next();
        }

        return items;
    }

    @Override
    public String toString() {
        String valueString = "";
        for(int value : values) {
            valueString += value;
            valueString += "\t";
        }

        String weightString = "";
        for(int weight : weights) {
            weightString += weight;
            weightString += "\t";
        }

        return "Values:\n" + valueString + "\nWeights:\n" + weightString;
    }
}
