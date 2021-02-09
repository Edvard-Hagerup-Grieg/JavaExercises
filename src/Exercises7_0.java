// Частотный словарь слов.

import java.util.HashMap;
import java.util.Map;

class EmptyStringException extends Exception {
    private String message = "";

    EmptyStringException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}

public class Exercises7_0 {

    public static HashMap<String, Double> getFreq(String text) throws EmptyStringException {
        if(text.equals("")) {
            throw new EmptyStringException("The text doesn't contain any words.");
        }

        text = text.replaceAll("[,.();\"1234567890]", "");
        text = text.toLowerCase();

        double numWords = 0.0;
        HashMap<String, Double> frq = new HashMap<>();
        for(String word : text.split(" ")) {
            if(frq.containsKey(word)) {
                double value = frq.get(word);
                frq.put(word, value + 1.0);
            } else {
                frq.put(word, 1.0);
            }
            numWords++;
        }

        for(String key : frq.keySet()) {
            double value = frq.get(key);
            frq.put(key, value / numWords);
        }

        return frq;
    }

    public static void main(String[] args) {
        String text = "Early Revolution Revolution Revolution";

        try {
            HashMap<String, Double> frq = getFreq(text);

            for(Map.Entry<String, Double> entry : frq.entrySet()) {
                System.out.println(entry.getKey() + " : " + String.format("%.3g", entry.getValue()));
            }
        } catch (EmptyStringException e) {
            System.out.println(e);
        }
    }
}
