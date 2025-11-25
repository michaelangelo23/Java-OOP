package passwordentry.core;

import java.util.Random;

public class Authenticator {
    private final String actualPin;
    private final int[] mapping;
    private final Random random;

    public Authenticator(String actualPin) {
        this.actualPin = actualPin;
        this.mapping = new int[10];
        this.random = new Random();
        generateMapping();
    }

    /**
     * Generates a random number (1-3) for each digit (0-9).
     */
    public void generateMapping() {
        for (int i = 0; i < 10; i++) {
            mapping[i] = random.nextInt(3) + 1;
        }
    }

    /**
     * Returns the current mapping of digits 0-9 to random numbers.
     * 
     * @return int array of size 10
     */
    public int[] getMapping() {
        return mapping;
    }

    /**
     * Authenticates the user's response against the actual PIN and current mapping.
     * 
     * @param userResponse The string of numbers entered by the user.
     * @return true if the response matches the PIN based on the mapping, false
     *         otherwise.
     */
    public boolean authenticate(String userResponse) {
        if (userResponse == null || userResponse.length() != actualPin.length()) {
            return false;
        }

        for (int i = 0; i < actualPin.length(); i++) {
            int pinDigit = Character.getNumericValue(actualPin.charAt(i));
            int expectedRandomNum = mapping[pinDigit];
            int userDigit = Character.getNumericValue(userResponse.charAt(i));

            if (userDigit != expectedRandomNum) {
                return false;
            }
        }
        return true;
    }

    public String getPin() {
        return actualPin;
    }
}
