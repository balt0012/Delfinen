import java.lang.reflect.Array;
import java.util.ArrayList;

public class Competition {
    private String discipline;
    private ArrayList<CompetitiveSwimmer> competitors;
    private ArrayList<Result> results = new ArrayList<>();


    public Competition(String discipline, ActiveDisciplinesClub activeDisciplinesClub, DataGetTopFive dataGetTopFive)
    {
        this.discipline = discipline;
        addCompetitors(activeDisciplinesClub, dataGetTopFive);
        addResults();

    }

    public void addCompetitors(ActiveDisciplinesClub activeDisciplinesClub, DataGetTopFive dataGetTopFive){

        String discipline = activeDisciplinesClub.inputDiscipline();
        ArrayList<CompetitiveSwimmer> activeSwimmerInDiscipline = dataGetTopFive.getCompetitiveSwimmersInDiscipline(discipline, Data.getCompetitiveSwimmers());
        if (activeSwimmerInDiscipline.size() < 5) {
            System.out.println("Error. Not enough active swimmers in this discipline to enter competitions.");
        } else {
            competitors = dataGetTopFive.findTop5InDiscipline(discipline, activeSwimmerInDiscipline);
        }

    }
    public void addResults() {
        for (int i = 0; i < competitors.size(); i++) {
            results.add(new Result(competitors.get(i), discipline));
        }
    }

    public void showSwimmers() {

        System.out.println("Swimmers for this competition:");

        for (int i = 0; i < competitors.size(); i++) {
            System.out.println(competitors.get(i).getName());
        }
    }
}


