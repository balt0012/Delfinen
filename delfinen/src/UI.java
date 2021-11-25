import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);

    public double inputTime() {
        boolean loop = true;

        System.out.println("Enter minutes");
        System.out.print(">");
        double timeMinutes = scanner.nextDouble();

        System.out.println("Enter seconds");
        System.out.print(">");
        double timeSeconds = scanner.nextDouble();

        return timeMinutes + (timeSeconds/100);
    }
}
