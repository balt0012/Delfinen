import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputTime {
    Scanner scanner = new Scanner(System.in);


    public float receiveTime() {
        int minutes = minutes();
        int seconds = seconds();

        return minutes + ((float)seconds/100);
    }

    public int minutes() {
        boolean loop = true;
        int userInput = 0;

        while (loop) {
            System.out.println("Please enter the amount of minutes");
            System.out.print(">");
            try {
                userInput = scanner.nextInt();
                if (validateTime(userInput)) {
                    loop = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Input must be a whole number without decimals.");
            }
        }
        return userInput;
    }

    public int seconds() {
        boolean loop = true;
        int userInput = 0;

        while (loop) {
            System.out.println("Please enter the amount of seconds");
            System.out.print(">");
            try {
                userInput = scanner.nextInt();
                if (validateTime(userInput)) {
                    loop = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Input must be a whole number without decimals.");
            }
        }
        return userInput;

    }

    public boolean validateTime(int time) {
        boolean isValid = true;

        if (time < 0 || time > 59) {
            // minutes and seconds can't be below 0 or higher than 59.
            System.out.println("Error. Input must be higher than zero and below 59.");
            isValid = false;
        }
        return isValid;
    }

}
