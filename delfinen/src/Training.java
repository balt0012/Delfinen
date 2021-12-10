import java.util.ArrayList;

public class Training {
    String discipline;
    int time;
    Team team;
    ArrayList<Result> result; // recycle that class maybe? Otherwise, create result class for training.

    public Training(String discipline, Team team, int time) {
        this.discipline = discipline;
        this.team = team;
        this.time = time;
    }

    public void registerResultForSwimmer() {
        for (int i = 0; i < team.getRoster().size(); i++) {

            // create trainingResult object here and add to result Arraylist.
        }
    }
    public int getTime() {
        return time;
    }

    public String getDiscipline() {
        return discipline;
    }
}
