import java.util.InputMismatchException;
import java.util.Scanner;

public class Result
{
    // Lavet af Ella.
    private double competitionTime;
    private String discipline;
    private CompetitiveSwimmer competitiveSwimmer;
    private int placement;

    public Result(CompetitiveSwimmer competitiveSwimmer, String discipline)
    {
        this.competitionTime = new UserInputTime().receiveTime();
        this.discipline = discipline;
        this.competitiveSwimmer = competitiveSwimmer;
        this.placement = receivePlacement();
    }

    public int receivePlacement() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        int input = 0;

        System.out.println("Please enter the placement for " + competitiveSwimmer);

        while (loop) {
            try {
                System.out.print(">");
                input = scanner.nextInt();
                loop = false;
            } catch (InputMismatchException e) {
                System.out.println("Error. Input must be a number with no decimals");
                scanner.next();
            }
        }
        return input;
    }


}
