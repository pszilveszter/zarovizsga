package hu.nive.ujratervezes.zarovizsga;

import java.util.*;

public class DigitsCounter {

    public int getCountOfDigits(String s) {
        if (s == null) {
            return 0;
        }

        Set<Character> ints = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < 57 && c > 47) {
                ints.add(c);
            }
        }
        return ints.size();
    }
}
