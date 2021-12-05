import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class CompetitiveSwimmer extends Member {
    private final ArrayList<Competition> competitions = new ArrayList<>();
    private final ArrayList<Training> trainingTimes = new ArrayList<>();
    private final ArrayList<String> activeDisciplinesSwimmer = new ArrayList<>();
    private String coach;
    private String coachID;
    private String team;

    public CompetitiveSwimmer(int age, String memberID, boolean isActive, String name) {
        super(age, memberID, isActive, name);
    }

    public ArrayList<Training> getTrainingTimes() {
        return trainingTimes;
    }

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }

    public void addCompetition(Competition competition) {
        competitions.add(competition);
    }

    public void addTraining(Training training) {
        SwimmerComparator swimmerComparator = new SwimmerComparator();
        trainingTimes.add(training);
        // crucial that trainingTimes Arraylist is sorted by fastest times if this class is to work with DataGetTopFive class.
        Collections.sort(trainingTimes, swimmerComparator);
    }

    public void addCoach(Coach coach) {
        this.coach = coach.getName();
        this.coachID = coach.getCoachId();
    }

    /*public boolean addSwimmerToDiscipline(String discipline, ValidateDisciplines validateDisciplines) {
        boolean swimmerIsAdded = false;
        // assigns a swimmer to a discipline if the swimmer is not already active within that discipline and the discipline is active in the club.
        if (!validateDisciplines.swimmerIsActiveInDiscipline(discipline, activeDisciplinesSwimmer) && validateDisciplines.validateDiscipline(discipline)) {
            activeDisciplinesSwimmer.add(discipline);
            swimmerIsAdded = true;
        }
        return swimmerIsAdded;
    }*/

    public void removeSwimmerFromDiscipline(String discipline) {
        for (int i = 0; i < activeDisciplinesSwimmer.size(); i++) {
            if (discipline.toLowerCase(Locale.ROOT).equals(activeDisciplinesSwimmer.get(i))) {
                activeDisciplinesSwimmer.remove(i);
                break;
            }
        }
    }

    public boolean swimmerIsActiveInDiscipline(String discipline) {
        // returns true if swimmer is active in a category
        boolean isActiveInDiscipline = false;

        for (int i = 0; i < activeDisciplinesSwimmer.size(); i++) {
            if (activeDisciplinesSwimmer.get(i).equals(discipline)) {
                isActiveInDiscipline = true;
                break;
            }
        }
        return isActiveInDiscipline;
    }
}

