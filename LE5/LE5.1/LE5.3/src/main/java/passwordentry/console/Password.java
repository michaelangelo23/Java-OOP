package passwordentry.console;

import passwordentry.core.Authenticator;
import java.util.Scanner;

public class Password {
    public static void main(String[] args) {

        String actualPin = "82122";
        Authenticator auth = new Authenticator(actualPin);
        Scanner scanner = new Scanner(System.in);

        int[] mapping = auth.getMapping(); // display and iterate mapping
        System.out.print("PIN : ");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.print("NUM : ");
        for (int num : mapping) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("\nEnter the response based on your PIN (" + actualPin + "):");
        String response = scanner.nextLine();

        if (auth.authenticate(response)) {
            System.out.println("Authentication Successful!");
        } else {
            System.out.println("Authentication Failed.");
        }

        scanner.close();
    }
}
