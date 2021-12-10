import java.util.ArrayList;
import java.util.Locale;

public class DatabaseClubDisciplines {
    // class responsible for storing the disciplines that the club is active in competitively.
    private ArrayList<String> clubDisciplines = new ArrayList<>();

    public ArrayList<String> getClubDisciplines() {
        return clubDisciplines;
    }

    public void addDiscipline(String discipline) {

        if (!checkForDuplicates(discipline)) {
            clubDisciplines.add(discipline.toLowerCase(Locale.ROOT));
            System.out.println("Discipline added.");
        }

    }

    public boolean checkForDuplicates(String discipline) {
        boolean isADuplicate = false;

        for (int i = 0; i < clubDisciplines.size(); i++) {
            if (clubDisciplines.get(i).equals(discipline.toLowerCase(Locale.ROOT))) {
                isADuplicate = true;
                System.out.println("Discipline already exist.");
                break;
            }
        }
        return isADuplicate;
    }
}
