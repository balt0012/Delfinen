import java.util.InputMismatchException;
import java.util.Scanner;

public class InputCreateMember {
    private Scanner scanner = new Scanner(System.in);

    public int receiveAge() {
        boolean loop = true;
        int userInputAge = 0;

        while (loop) {

            try {
                System.out.println(">");
                userInputAge = scanner.nextInt();

                if (userInputAge < 0) {
                    System.out.println("Error. Age can't be below zero.");
                } else {
                    loop = false;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error. Age must be a number with no decimals");
            }
        }
       return userInputAge;
    }

    public String receiveName() {
        return scanner.nextLine();
    }

    public boolean receiveActiveStatus() {
        boolean loop = true;
        String userInput = null;
        boolean memberIsActive = true;

        System.out.println("Please enter the members active status:\n1 - If the member is active\n2 - if the member is not active.");

        while (loop) {
            System.out.print(">");
            userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                // 1 if member is active
                loop = false;
            } else if (userInput.equals("2")) {
                // 2 if member is inactive.
                memberIsActive = false;
                loop = false;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
        return memberIsActive;
    }


}
