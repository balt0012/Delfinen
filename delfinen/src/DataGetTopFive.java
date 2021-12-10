import java.util.ArrayList;
import java.util.Collections;

public class DataGetTopFive {
    // Lavet af Carl.
    SwimmerComparator swimmerComparator = new SwimmerComparator();

    public ArrayList<CompetitiveSwimmer> findTop5InDiscipline(String discipline, ArrayList<CompetitiveSwimmer> swimmersActiveInDiscipline) {
        ArrayList<TrainingResult> bestTimesInDisciplineBySwimmers = getBestTimeInDisciplineFromSwimmer(discipline, swimmersActiveInDiscipline);
        Collections.sort(bestTimesInDisciplineBySwimmers, swimmerComparator);
        ArrayList<CompetitiveSwimmer> top5Swimmers = new ArrayList<>();
        // due to the fact that this arraylist is sorted by fastest time, the first five elements in the arraylist
        // will be the top5 within the defined discipline.
        for (int i = 0; i < 5; i++) {
            top5Swimmers.add(bestTimesInDisciplineBySwimmers.get(i).getCompetitiveSwimmer());
        }
        return top5Swimmers;
    }

    public ArrayList<CompetitiveSwimmer> getCompetitiveSwimmersInDiscipline(String discipline, ArrayList<CompetitiveSwimmer> competitiveSwimmers) {
        // method iterates through arraylist of swimmers and adds all swimmer who are active
        // in the discipline defined by the method parameter 'discipline' to a new arraylist.
        ArrayList<CompetitiveSwimmer> swimmersActiveInDiscipline = new ArrayList<>();

        for (int i = 0; i < competitiveSwimmers.size(); i++) {
            if (competitiveSwimmers.get(i).swimmerIsActiveInDiscipline(discipline)) {
                // returns true if swimmer is active in that discipline.
                swimmersActiveInDiscipline.add(competitiveSwimmers.get(i));
            }
        }
        return swimmersActiveInDiscipline;
    }

    public ArrayList<TrainingResult> getBestTimeInDisciplineFromSwimmer(String discipline, ArrayList<CompetitiveSwimmer> swimmersActiveInDiscipline) {
        // key to this method is that the trainingTimes arraylist is sorted by fastest time in the competitiveSwimmer class.
        // Using a nested loop this method iterates through all active swimmers in the defined discipline
        // and all there training times until the disciplines matches.
        // because the arraylist is sorted we know that the first match is the fastest time within the defined discipline.
        ArrayList<TrainingResult> bestTimeInDisciplineSwimmer = new ArrayList<>();
        for (int i = 0; i < swimmersActiveInDiscipline.size(); i++) {
            for (int n = 0; n < swimmersActiveInDiscipline.get(i).getTrainingTimes().size(); n++) {
                if (swimmersActiveInDiscipline.get(i).getTrainingTimes().get(n).getDiscipline().equals(discipline)) {
                    bestTimeInDisciplineSwimmer.add(swimmersActiveInDiscipline.get(i).getTrainingTimes().get(n));
                }
            }
        }
        return bestTimeInDisciplineSwimmer;
    }
}
