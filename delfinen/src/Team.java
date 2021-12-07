import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Team {
    private final ArrayList<CompetitiveSwimmer> roster = new ArrayList<>();
    private String teamName;
    private Trainer trainer;

    public Team(String teamName, Trainer trainer) {
        this.teamName = teamName;
        this.trainer = trainer;
    }

    public ArrayList<CompetitiveSwimmer> getRoster() {
        return roster;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public void addSwimmerToTeam(CompetitiveSwimmer competitiveSwimmer) {
        roster.add(competitiveSwimmer);
    }

    public static Team createTeam(String teamName) {
        Scanner scanner = new Scanner(System.in);
        boolean matchIsFound = false;
        boolean loop = true;
        String trainerName;
        Trainer trainer = null;
        System.out.println("Please enter ID of the coach you would like to put in charge of " + teamName);

        for (int i = 0; i < Data.getTrainers().size(); i++) {
            System.out.println("Name: " + Data.getTrainers().get(i).getTrainerName() + " ID: "+ Data.getTrainers().get(i).getTrainerID());
        }

        while (loop) {
            System.out.print(">");
            trainerName = scanner.nextLine().toLowerCase(Locale.ROOT);

            for (int i = 0; i < Data.getTrainers().size(); i++) {
                if (trainerName.equals(Data.getTrainers().get(i).getTrainerID())) {
                    trainer = Data.getTrainers().get(i);
                    matchIsFound = true;
                }
            }

            if (matchIsFound) {
                loop = false;
            }
        }
        return new Team(teamName, trainer);
    }
}
