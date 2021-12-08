import java.lang.reflect.Array;
import java.util.ArrayList;

public class Competition {

    private String name;
    private ArrayList<CompetitiveSwimmer> competitors;
    private ArrayList<Result> results = new ArrayList<>();
    private int competitionCounter;
    private int resultCounter;

    public Competition(String name, double competitionTime)
    {
        this.name = name;
        this.competitionCounter  = 0;
        this.resultCounter = 0;
    }

    public void addCompetitors(){
        DataGetTopFive dataGetTopFive = new DataGetTopFive();
        ActiveDisciplinesClub activeDisciplinesClub = new ActiveDisciplinesClub();
        String discipline = activeDisciplinesClub.inputDiscipline();

        ArrayList<CompetitiveSwimmer> activeSwimmerInDiscipline = dataGetTopFive.getCompetitiveSwimmersInDiscipline(discipline, Data.getCompetitiveSwimmers());
        competitors = dataGetTopFive.findTop5InDiscipline(discipline, activeSwimmerInDiscipline);

    }
    public void addResult(Result result){
        if(resultCounter <= 4){
            results[resultCounter] = result;
            resultCounter++;
        }
    }
}


