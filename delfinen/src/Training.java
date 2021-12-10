import java.util.ArrayList;
import java.util.Collections;

public class Training {
    // Lavet af Carl.
    String discipline;
    Team team;
    ArrayList<TrainingResult> results = new ArrayList<>();


    public Training(String discipline, Team team) {
        this.discipline = discipline;
        this.team = team;
        registerResultForSwimmer();
    }

    public void registerResultForSwimmer() {
        UserInputTime userInputTime = new UserInputTime();
        SwimmerComparator swimmerComparator = new SwimmerComparator();

        for (int i = 0; i < team.getRoster().size(); i++) {
            // iterates through the team rooster. if the swimmer is active in the discipline being trained
            // then the user will be able to input individual times. The method will then create the objects and add them to results arraylist and an TrainingResult arraylist
            // within the respective competitive swimmer object.

            if (team.getRoster().get(i).swimmerIsActiveInDiscipline(discipline)) {
                System.out.println("Please enter the time for " + team.getRoster().get(i).getName() + " ID: " + team.getRoster().get(i).getMemberID());
                TrainingResult trainingResult = new TrainingResult(discipline, team.getRoster().get(i), userInputTime.receiveTime());
                results.add(trainingResult);
                team.getRoster().get(i).addTrainingResult(trainingResult);
            }
        }
        Collections.sort(results, swimmerComparator);

    }

    public void showTraining() {
        for (int i = 0; i < results.size(); i++) {
            System.out.println("Discipline: " + discipline + "\nSwimmer name: " + results.get(i).getCompetitiveSwimmer().getName() + "\nTime: " + results.get(i).getTime());
        }
    }

    public String getDiscipline() {
        return discipline;
    }
}
