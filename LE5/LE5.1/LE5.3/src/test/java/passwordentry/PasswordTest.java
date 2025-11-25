package passwordentry;

import org.junit.jupiter.api.Test;
import passwordentry.core.Authenticator;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void testGenerateMapping() {
        Authenticator auth = new Authenticator("12345");
        int[] mapping = auth.getMapping();

        assertNotNull(mapping);
        assertEquals(10, mapping.length);

        for (int num : mapping) {
            assertTrue(num >= 1 && num <= 3, "Random number should be between 1 and 3");
        }
    }

    @Test
    void testAuthenticateSuccess() {
        String pin = "12345";
        Authenticator auth = new Authenticator(pin);
        int[] mapping = auth.getMapping();

        StringBuilder correctResponse = new StringBuilder();
        for (char c : pin.toCharArray()) {
            int digit = Character.getNumericValue(c);
            correctResponse.append(mapping[digit]);
        }

        assertTrue(auth.authenticate(correctResponse.toString()),
                "Authentication should succeed with correct response");
    }

    @Test
    void testAuthenticateFailure() {
        Authenticator auth = new Authenticator("12345");
        assertFalse(auth.authenticate("00000"), "Authentication should fail with incorrect response");
    }

    @Test
    void testAuthenticateWrongLength() {
        Authenticator auth = new Authenticator("12345");
        assertFalse(auth.authenticate("1234"), "Authentication should fail with short response");
        assertFalse(auth.authenticate("123456"), "Authentication should fail with long response");
    }
}
