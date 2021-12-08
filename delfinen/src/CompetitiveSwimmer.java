import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

public class CompetitiveSwimmer extends Member {
    private final ArrayList<Competition> competitions = new ArrayList<>();
    private final ArrayList<TrainingResult> trainingTimes = new ArrayList<>();
    private final ArrayList<String> activeDisciplinesSwimmer = new ArrayList<>();
    private Trainer trainer;
    private String coachID;
    private String team;

    public CompetitiveSwimmer(int age, String memberID, boolean isActive, String name) {
        super(age, memberID, isActive, name);
    }

    public ArrayList<TrainingResult> getTrainingTimes() {
        return trainingTimes;
    }

    public ArrayList<Competition> getCompetitions() {
        return competitions;
    }

    public void addCompetition(Competition competition) {
        competitions.add(competition);
    }

    public void addTraining(TrainingResult trainingResult) {
        SwimmerComparator swimmerComparator = new SwimmerComparator();
        trainingTimes.add(trainingResult);
        // crucial that trainingTimes Arraylist is sorted by fastest times if this class is to work with DataGetTopFive class.
        Collections.sort(trainingTimes, swimmerComparator);
    }

    public void addCoach(Trainer trainer) {
        this.trainer = trainer.getName();
        this.trainer = trainer.getCoachId();
    }

    public boolean addSwimmerToDiscipline(String discipline, ActiveDisciplinesClub activeDisciplinesClub) {
        boolean swimmerIsAdded = false;
        // assigns a swimmer to a discipline if the swimmer is not already active within that discipline and the discipline is active in the club.
        if (swimmerIsActiveInDiscipline(discipline) && !activeDisciplinesClub.validateDiscipline(discipline)) {
            activeDisciplinesSwimmer.add(discipline);
            swimmerIsAdded = true;
        }
        return swimmerIsAdded;
    }

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

    public static void createCompetitiveSwimmer() {
        InputCreateMember inputCreateMember = new InputCreateMember();
        CompetitiveSwimmer competitiveSwimmer = new CompetitiveSwimmer(inputCreateMember.receiveAge(), GenerateID.generateID(), inputCreateMember.receiveActiveStatus(), inputCreateMember.receiveName());
        Data.addToMembers(competitiveSwimmer);
        Data.addMemberToTeam(Data.getSeniorTeam(), Data.getJuniorTeam(), competitiveSwimmer);

    }

    public void addTrainingResult(TrainingResult trainingResult) {
        trainingTimes.add(trainingResult);
    }
}

