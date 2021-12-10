import java.util.ArrayList;
import java.util.Collections;

public class DataGetTopFive {
    SwimmerComparator swimmerComparator = new SwimmerComparator();
    /*public ArrayList<CompetitiveSwimmer> findTop5InDiscipline(String discipline, ArrayList<CompetitiveSwimmer> swimmersActiveInDiscipline) {
        ArrayList<Training> bestTimesInDisciplineBySwimmers = getBestTimeInDisciplineFromSwimmer(discipline, swimmersActiveInDiscipline);
        Collections.sort(bestTimesInDisciplineBySwimmers, swimmerComparator);
        ArrayList<CompetitiveSwimmer> top5Swimmers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            top5Swimmers.add(bestTimesInDisciplineBySwimmers.get(i).getCompetitiveSwimmer());
        }
        return top5Swimmers;
    }*/

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

    public ArrayList<Training> getBestTimeInDisciplineFromSwimmer(String discipline, ArrayList<CompetitiveSwimmer> swimmersActiveInDiscipline) {
        // prototype. Might implement another method to implement this feature.
        ArrayList<Training> bestTimeInDisciplineSwimmer = new ArrayList<>();
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
