package demofortesting.demofortesting.model;

import java.util.HashMap;
import java.util.Map;

public class TestP {
    public static void main(String[] args) {
        String[] arr = {"adjjfsadhfurefcdfbjjfebfbnfbnafeh"};

        for (String s : arr) {
            Map<Character, Integer> charCount = new HashMap<>();
            for (char c : s.toCharArray()) {
                if (charCount.containsKey(c)) {
                    charCount.put(c, charCount.get(c) + 1);
                } else {
                    charCount.put(c, 1);
                }
            }

            int dupCount = 0;
            for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
                if (entry.getValue() > 1) {
                    dupCount++;
                }
            }

            System.out.println("String: " + s + " has " + dupCount + " duplicate characters.");
        }
    }
}

