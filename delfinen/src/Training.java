import java.util.ArrayList;

public class Training {
    String discipline;
    Team team;
    ArrayList<TrainingResult> results;

    public Training(String discipline, Team team) {
        this.discipline = discipline;
        this.team = team;
    }

    public void registerResultForSwimmer() {
        UserInputTime userInputTime = new UserInputTime();

        for (int i = 0; i < team.getRoster().size(); i++) {
            // iterates through the team rooster. if the swimmer is active in the discipline being trained
            // then the user will be able to input individual times. The method will then create the objects and add them to results arraylist and an TrainingResult arraylist
            // within the respective competitive swimmer object.

            if (team.getRoster().get(i).swimmerIsActiveInDiscipline(discipline)) {
                System.out.println("Please enter the time for " + team.getRoster().get(i).getName() + " (ID: " + team.getRoster().get(i).getMemberID());
                TrainingResult trainingResult = new TrainingResult(discipline, team.getRoster().get(i), userInputTime.receiveTime());
                results.add(trainingResult);
                team.getRoster().get(i).addTrainingResult(trainingResult);
            }
        }
    }

    public String getDiscipline() {
        return discipline;
    }
}
