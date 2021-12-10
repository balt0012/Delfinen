import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Trainer
    // Lavet af Ella
{
    //We have ONE trainer, we are cheap
    private String trainerName;
    private String trainerID;

    public Trainer(String trainerName)
    {
        this.trainerName = trainerName;
        this.trainerID = GenerateID.generateID();
    }

    public static Trainer createTrainer() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the name of the coach:");
        System.out.print(">");
        String name = scanner.nextLine().toLowerCase(Locale.ROOT);

        return new Trainer(name);
    }

    public String getTrainerID() {
        return trainerID;
    }

    public String getTrainerName() {
        return trainerName;
    }

    //Will work on the method tomorrow (25/11) as the team class needs some filling to make the method.

}
