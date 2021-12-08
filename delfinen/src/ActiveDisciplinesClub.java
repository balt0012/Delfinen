import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class ActiveDisciplinesClub {
    private ArrayList<String> clubDisciplines = new ArrayList<>();


    public ActiveDisciplinesClub() {
        clubDisciplines.add("backstroke");
        clubDisciplines.add("butterfly");
        clubDisciplines.add("crawl");
        clubDisciplines.add("breaststroke");
        clubDisciplines.add("backcrawl");
    }

    public void addDiscipline() {
        System.out.println("Please enter the discipline you would like to add:");
        clubDisciplines.add(inputNewDiscipline());
    }

    public boolean validateDiscipline(String discipline) {
        // returns true if parameter discipline is found in clubDisciplines arraylist.
        boolean isADuplicate = false;

        for (int i = 0; i < clubDisciplines.size(); i++) {

            if (clubDisciplines.get(i).equals(discipline)) {
                isADuplicate = true;
            }
        }
        return isADuplicate;
    }

    public String inputNewDiscipline() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String userInput = null;

        while (loop) {

            System.out.println(">");
            userInput = scanner.nextLine().toLowerCase(Locale.ROOT);

            if (!validateDiscipline(userInput)) {
                loop = false;
            }
        }
        return userInput;
    }

    public String inputDiscipline() {
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        String userInput = null;

        while (loop) {

            System.out.println(">");
            userInput = scanner.nextLine().toLowerCase(Locale.ROOT);

            if (validateDiscipline(userInput)) {
                loop = false;
            }
        }
        return userInput;


    }
}
